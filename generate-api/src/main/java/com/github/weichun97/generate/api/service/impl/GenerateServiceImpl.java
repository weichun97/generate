package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.GenerateContext;
import com.github.weichun97.generate.api.generate.TableDTO;
import com.github.weichun97.generate.api.generate.convert.ColumnTypeConverter;
import com.github.weichun97.generate.api.generate.convert.ColumnTypeConverterFactory;
import com.github.weichun97.generate.api.generate.parser.TemplateParser;
import com.github.weichun97.generate.api.generate.parser.TemplateParserFactory;
import com.github.weichun97.generate.api.generate.selector.SqlSelector;
import com.github.weichun97.generate.api.generate.selector.SqlSelectorFactory;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.mapper.DatasourceMapper;
import com.github.weichun97.generate.api.pojo.mapper.TableMapper;
import com.github.weichun97.generate.api.pojo.param.generate.GenerateParam;
import com.github.weichun97.generate.api.pojo.vo.generate.GenerateVO;
import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;
import com.github.weichun97.generate.api.service.DatasourceService;
import com.github.weichun97.generate.api.service.GenerateService;
import com.github.weichun97.generate.api.service.TemplateDetailService;
import com.github.weichun97.generate.api.util.JdbcUtils;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.exception.ApiException;
import com.github.weichun97.generate.common.exception.BizAssert;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/12 16:58
 */
@Slf4j
@Service
public class GenerateServiceImpl implements GenerateService {

    @Resource
    private TableMapper tableMaps;
    @Resource
    private DatasourceMapper datasourceMaps;
    @Resource
    private DatasourceService datasourceService;
    @Resource
    private TemplateDetailService templateDetailService;
    @Resource
    private Configuration configuration;

    @Override
    public List<GenerateVO> generate(GenerateParam generateParam) {
        DatasourceEntity datasourceEntity = datasourceService.getById(generateParam.getDatasourceId());
        BizAssert.assertNotNull(datasourceEntity, ResultCode.CODE_10004);
        try (Connection connect = JdbcUtils.getConnect(datasourceMaps.poToJdbcParam(datasourceEntity))) {
            SqlSelector sqlSelector = SqlSelectorFactory.get(datasourceEntity.getDbType());
            SqlRunner sqlRunner = new SqlRunner(connect);

            // 获取数据
            List<TableDTO> tableDTOS = sqlSelector.listTableInfo(sqlRunner, datasourceEntity.getDbName(), generateParam.getTableNames(), datasourceEntity.getDelPrefix());
            List<ColumnDTO> columnDTOS = sqlSelector.listColumnInfo(sqlRunner, datasourceEntity.getDbName(), generateParam.getTableNames());

            Map<String, List<ColumnDTO>> tableNameOfColumnDtos = StreamEx.of(columnDTOS).groupingBy(ColumnDTO::getTableName);
            List<TemplateDetailEntity> templateDetailEntities = templateDetailService.list(new LambdaQueryWrapper<TemplateDetailEntity>()
                    .in(TemplateDetailEntity::getId, generateParam.getTemplateIds())
            );
            // 生成
            List<GenerateVO> rootGenerateVOS = CollUtil.newArrayList();
            Map<String, GenerateVO> generateVoMap = new HashMap<>();
            for (TemplateDetailEntity templateDetailEntity : templateDetailEntities) {
                ColumnTypeConverter columnTypeConverter = ColumnTypeConverterFactory.get(1);

                for (TableDTO tableDTO : tableDTOS) {
                    GenerateContext generateContext = GenerateContext.builder()
                            .table(tableDTO)
                            .columns(parseColumnType(columnTypeConverter, tableNameOfColumnDtos.get(tableDTO.getName())))
                            .build();

                    // 带目录的模板
                    if(StrUtil.isNotBlank(templateDetailEntity.getDir())){
                        List<String> dirs = StrUtil.split(templateDetailEntity.getDir(), "/");
                        StringBuilder curDir = new StringBuilder();
                        List<GenerateVO> parentGenerateVOS = rootGenerateVOS;
                        // 生成文件夹的树形结构
                        for (String dir : dirs) {
                            // 第一个文件夹
                            if(parentGenerateVOS.equals(rootGenerateVOS)){
                                curDir.append(dir);
                            }
                            // 后续文件夹
                            else{
                                curDir.append("/").append(dir);
                            }
                            if(!generateVoMap.containsKey(curDir.toString())){
                                GenerateVO generateVO = GenerateVO.builder()
                                        .dirOrFileName(dir)
                                        .children(CollUtil.newArrayList())
                                        .build();
                                parentGenerateVOS.add(generateVO);
                                generateVoMap.put(curDir.toString(), generateVO);
                            }
                            parentGenerateVOS = generateVoMap.get(curDir.toString()).getChildren();
                        }

                        // 生成文件数据
                        TemplateParser templateParser = TemplateParserFactory.get(1);
                        GenerateVO generateVO = GenerateVO.builder()
                                .dirOrFileName(templateParser.parse(generateContext, templateDetailEntity.getFileName()))
                                .content(templateParser.parse(generateContext, templateDetailEntity.getContent()))
                                .build();
                        parentGenerateVOS.add(generateVO);
                    }
                    // 不带目录的模板
                    else{
                        // 生成文件数据
                        TemplateParser templateParser = TemplateParserFactory.get(1);
                        GenerateVO generateVO = GenerateVO.builder()
                                .dirOrFileName(templateParser.parse(generateContext, templateDetailEntity.getFileName()))
                                .content(templateParser.parse(generateContext, templateDetailEntity.getContent()))
                                .build();
                        rootGenerateVOS.add(generateVO);
                    }
                }
            }
            return rootGenerateVOS;
        } catch (SQLException e) {
            throw new ApiException(ResultCode.CODE_10005, String.format("sql执行失败,%s", e.getMessage()));
        } catch (TemplateException e) {
            throw new ApiException(ResultCode.CODE_10006, String.format("模板解析异常,%s", e.getMessage()));
        } catch (IOException e) {
            throw new ApiException(ResultCode.CODE_10006, String.format("模板解析异常,%s", e.getMessage()));
        }
    }

    /**
     * 解析字段类型
     *
     * @param columnTypeConverter
     * @param columnDTOS
     * @return
     */
    private List<ColumnDTO> parseColumnType(ColumnTypeConverter columnTypeConverter, List<ColumnDTO> columnDTOS) {
        columnDTOS.forEach(columnDTO -> {
            columnDTO.setBaseType(columnTypeConverter.convertType(columnDTO.getType()));
            columnDTO.setBoxType(columnTypeConverter.convertTypeBox(columnDTO.getType()));
        });
        return columnDTOS;
    }

    @Override
    public List<String> types() {
        return null;
    }

    @Override
    public List<TablesVO> tables(Long datasourceId) {
        DatasourceEntity datasource = datasourceService.getById(datasourceId);
        BizAssert.assertNotNull(datasource, ResultCode.CODE_10004);

        SqlSelector sqlSelector = SqlSelectorFactory.get(datasource.getDbType());
        try (Connection connect = JdbcUtils.getConnect(datasourceMaps.poToJdbcParam(datasource))) {
            List<TablesVO> tablesVOS = tableMaps.dtoToVo(sqlSelector.listTableInfo(new SqlRunner(connect), datasource.getDbName(), null, null));
            return CollUtil.isEmpty(tablesVOS) ? Collections.emptyList() : tablesVOS;
        } catch (SQLException e) {
            throw new ApiException(ResultCode.CODE_10005, String.format("sql执行失败,%s", e.getMessage()));
        }
    }
}
