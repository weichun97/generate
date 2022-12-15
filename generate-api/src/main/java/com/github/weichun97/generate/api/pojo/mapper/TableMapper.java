package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TableMapper {

    @Mappings({
            @Mapping(expression = "java(map.get(\"NAME\").toString())", target = "name"),
            @Mapping(expression = "java(map.get(\"COMMENT\").toString())", target = "comment"),
    })
    TablesVO mapToTablesVo(Map<String, Object> map);
    List<TablesVO> mapToTablesVo(List<Map<String, Object>> map);
}
