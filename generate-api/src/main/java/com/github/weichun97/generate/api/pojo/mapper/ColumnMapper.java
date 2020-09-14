package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.dto.generate.ColumnDTO;
import com.github.weichun97.generate.api.pojo.entity.ColumnEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface ColumnMapper {

    @Mappings({
            @Mapping(target = "oldColumnName", source = "columnName"),
            @Mapping(target = "columnName", expression = "java(cn.hutool.core.util.StrUtil.toCamelCase(columnEntity.getColumnName()))"),
            @Mapping(target = "javaType", expression = "java(com.github.weichun97.generate.common.util.TableUtils.cloumnTypeToStr(columnEntity.getDataType()))")
    })
    ColumnDTO entityToDto(ColumnEntity columnEntity);

    List<ColumnDTO> entityToDto(List<ColumnEntity> columnEntities);
}
