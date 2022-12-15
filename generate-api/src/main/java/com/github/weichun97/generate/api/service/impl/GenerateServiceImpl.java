package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.weichun97.generate.api.config.GenerateProperties;
import com.github.weichun97.generate.api.generate.SqlSelector;
import com.github.weichun97.generate.api.generate.SqlSelectorFactory;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.mapper.ColumnMapper;
import com.github.weichun97.generate.api.pojo.mapper.DatasourceMapper;
import com.github.weichun97.generate.api.pojo.mapper.TableMapper;
import com.github.weichun97.generate.api.pojo.param.generate.GenerateParam;
import com.github.weichun97.generate.api.pojo.vo.generate.GenerateVO;
import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;
import com.github.weichun97.generate.api.service.ColumnService;
import com.github.weichun97.generate.api.service.DatasourceService;
import com.github.weichun97.generate.api.service.GenerateService;
import com.github.weichun97.generate.api.util.JdbcUtils;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.exception.ApiException;
import com.github.weichun97.generate.common.exception.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
    ColumnService columnService;
    @Resource
    GenerateProperties generateProperties;

    @Resource
    ColumnMapper columnMapper;

    @Override
    public List<GenerateVO> generate(GenerateParam generateParam) {
        DatasourceEntity datasourceEntity = datasourceService.getById(generateParam.getDatasourceId());
        BizAssert.assertNotNull(datasourceEntity, ResultCode.CODE_10004);
        try (Connection connect = JdbcUtils.getConnect(datasourceMaps.poToJdbcParam(datasourceEntity))) {
            SqlSelector sqlSelector = SqlSelectorFactory.get(datasourceEntity.getDbType());
            SqlRunner sqlRunner = new SqlRunner(connect);
            List<Map<String, Object>> maps = sqlRunner.selectAll(sqlSelector.showTablesSql(datasourceEntity.getDbName()));
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
        return new ArrayList<>(generateProperties.getTemplateMap().keySet());
    }

    @Override
    public List<TablesVO> tables(Long datasourceId) {
        DatasourceEntity datasource = datasourceService.getById(datasourceId);
        BizAssert.assertNotNull(datasource, ResultCode.CODE_10004);

        SqlSelector sqlSelector = SqlSelectorFactory.get(datasource.getDbType());
        try(Connection connect = JdbcUtils.getConnect(datasourceMaps.poToJdbcParam(datasource))) {
            List<TablesVO> tablesVOS = tableMaps.mapToTablesVo(new SqlRunner(connect).selectAll(sqlSelector.showTablesSql(datasource.getDbName())));
            return CollUtil.isEmpty(tablesVOS) ? Collections.emptyList() : tablesVOS;
        } catch (SQLException e) {
            throw new ApiException(ResultCode.CODE_10005, String.format("sql执行失败,%s", e.getMessage()));
        }
    }

}
