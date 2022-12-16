package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.engine.freemarker.SimpleStringTemplateLoader;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.weichun97.generate.api.config.FreemakerConfig;
import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.selector.SqlSelector;
import com.github.weichun97.generate.api.generate.selector.SqlSelectorFactory;
import com.github.weichun97.generate.api.generate.TableDTO;
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
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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
                    .in(TemplateDetailEntity::getTemplateId, generateParam.getTemplateIds())
            );
            // 生成
            List<GenerateVO> generateVOS = CollUtil.newArrayList();
            for (TemplateDetailEntity templateDetailEntity : templateDetailEntities) {
                if(StrUtil.isNotBlank(templateDetailEntity.getDir())){
                    List<String> dirs = StrUtil.split(templateDetailEntity.getDir(), "/");
//                    GenerateVO.builder()
                }

//                GenerateVO generateVO = new GenerateVO();
//                generateVO.setContent(templateDetailEntity.getContent());
//                generateVO.set(templateDetailEntity.getContent());

            }


            return Collections.emptyList();
        } catch (SQLException throwables) {
            throw new ApiException(ResultCode.CODE_10005, String.format("sql执行失败,%s", throwables.getMessage()));
        }

//        // 获取表结构
//        List<ColumnEntity> columnEntities = columnService.getByTableNames(generateReqVO.getTableNames());
//        Map<String, List<ColumnEntity>> tableNameColumnEntityMap = columnEntities.stream().collect(Collectors.groupingBy(ColumnEntity::getTableName));
//        List<TableInfoDTO> tableInfos = new ArrayList<>();
//        tableNameColumnEntityMap.forEach((k, v) -> {
//            TableEntity tableEntity = tableService.getByName(k);
//            if(tableEntity == null){
//                return;
//            }
//            tableInfos.add(TableInfoDTO.builder()
//                    .tableName(tableEntity.getTableName())
//                    .tableNameCamelCase(StrUtil.upperFirst(StrUtil.toCamelCase(tableEntity.getTableName())))
//                    .tableComment(tableEntity.getTableComment())
//                    .columnDtos(columnMapper.entityToDto(v))
//                    .build());
//        });
//
//        // 代码生成
//        tableInfos.forEach(tableInfo -> {
//            generateReqVO.getTypes().forEach(type -> {
//                if(GenarateFactory.get(generateProperties.getTemplateMap().get(type).getType()) == null){
//                    throw new RuntimeException("未定义的生成器类型["+ generateProperties.getTemplateMap().get(type).getType() +"]");
//                }
//                // 生成
//                GenerateProperties.Template template = generateProperties.getTemplateMap().get(type);
//                GenarateFactory.get(template.getType()).generate(tableInfo, template, generateReqVO.getModule());
//
//                // 递归生成子模板
//                if(template.getChild() != null){
//                    template.getChild().forEach((k, v) -> {
//                        GenarateFactory.get(v.getType()).generate(tableInfo, v, generateReqVO.getModule());
//                    });
//                }
//            });
//        });
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

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setTemplateLoader(new SimpleStringTemplateLoader());
        configuration.setClassicCompatible(true);
        configuration.setDefaultEncoding("UTF-8");
        Template template = Template.getPlainTextTemplate("name", "asdas${module}", configuration);
        StringWriter stringWriter = new StringWriter();
        template.process(MapUtil.builder()
                .put("module", "123")
                .build(), stringWriter);
        System.out.println(stringWriter.toString());
    }
}
