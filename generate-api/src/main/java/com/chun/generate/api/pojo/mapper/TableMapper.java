package com.chun.generate.api.pojo.mapper;

import com.chun.generate.api.pojo.entity.TableEntity;
import com.chun.generate.api.pojo.vo.generate.ListResVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TableMapper {
    /**
     * po 转 ListResVO
     * @param tableEntity 表信息
     * @return ListResVO
     */
    ListResVO poToListResVO(TableEntity tableEntity);

    /**
     * po 转 ListResVO
     * @param tableEntities 表信息
     * @return List<ListResVO>
     */
    List<ListResVO> poToListResVO(List<TableEntity> tableEntities);


}
