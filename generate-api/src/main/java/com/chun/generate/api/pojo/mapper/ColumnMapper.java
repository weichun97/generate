package com.chun.generate.api.pojo.mapper;

import com.chun.generate.api.pojo.dto.generate.ColumnDTO;
import com.chun.generate.api.pojo.entity.ColumnEntity;
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
            @Mapping(target = "columnName", expression = "java(cn.hutool.core.util.StrUtil.toCamelCase(columnEntity.getColumnName()))"),
            @Mapping(target = "javaType", expression = "java(com.chun.generate.common.util.TableUtils.cloumnTypeToStr(columnEntity.getDataType()))")
    })
    ColumnDTO entityToDto(ColumnEntity columnEntity);

    List<ColumnDTO> entityToDto(List<ColumnEntity> columnEntities);
}
