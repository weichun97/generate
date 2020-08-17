package com.chun.generate.api.service.impl;

import cn.hutool.core.util.StrUtil;
import com.chun.generate.api.config.GenerateProperties;
import com.chun.generate.api.generate.*;
import com.chun.generate.api.pojo.dto.generate.TableInfoDTO;
import com.chun.generate.api.pojo.mapper.ColumnMapper;
import com.chun.generate.api.pojo.entity.ColumnEntity;
import com.chun.generate.api.pojo.entity.TableEntity;
import com.chun.generate.api.pojo.vo.generate.GenerateReqVO;
import com.chun.generate.api.pojo.vo.generate.ListResVO;
import com.chun.generate.api.service.ColumnService;
import com.chun.generate.api.service.GenerateService;
import com.chun.generate.api.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chun
 * @date 2020/8/12 16:58
 */
@Slf4j
@Service
public class GenerateServiceImpl implements GenerateService {

    @Resource
    TableService tableService;
    @Resource
    ColumnService columnService;
    @Resource
    GenerateProperties generateProperties;

    @Resource
    ColumnMapper columnMapper;

    @Override
    public List<ListResVO> listQuery() {
        return tableService.listQuery();
    }

    @Override
    public void generate(GenerateReqVO generateReqVO) {
        // 获取表结构
        List<ColumnEntity> columnEntities = columnService.getByTableNames(generateReqVO.getTableNames());
        Map<String, List<ColumnEntity>> tableNameColumnEntityMap = columnEntities.stream().collect(Collectors.groupingBy(ColumnEntity::getTableName));
        List<TableInfoDTO> tableInfos = new ArrayList<>();
        tableNameColumnEntityMap.forEach((k, v) -> {
            TableEntity tableEntity = tableService.getByName(k);
            if(tableEntity == null){
                return;
            }
            tableInfos.add(TableInfoDTO.builder()
                    .tableName(tableEntity.getTableName())
                    .tableNameCamelCase(StrUtil.upperFirst(StrUtil.toCamelCase(tableEntity.getTableName())))
                    .tableComment(tableEntity.getTableComment())
                    .columnDtos(columnMapper.entityToDto(v))
                    .build());
        });

        // 代码生成
        tableInfos.forEach(tableInfo -> {
            generateReqVO.getTypes().forEach(type -> {
                GenarateFactory.get(generateProperties.getTemplateMap().get(type).getType()).generate(tableInfo, type);
            });
        });
    }

    @Override
    public List<String> types() {
        return new ArrayList<>(generateProperties.getTemplateMap().keySet());
    }

}
