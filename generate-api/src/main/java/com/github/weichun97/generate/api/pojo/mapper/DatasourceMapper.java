package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.param.datasource.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;
import com.github.weichun97.generate.api.util.JdbcUtils;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface DatasourceMapper {

    ListVO poToListVo(DatasourceEntity datasourceEntity);
    List<ListVO> poToListVo(List<DatasourceEntity> datasourceEntities);

    DatasourceEntity saveOrUpdateParamToPo(SaveOrUpdateParam saveOrUpdateParam);
    JdbcUtils.Param saveOrUpdateParamToJdbcParam(SaveOrUpdateParam saveOrUpdateParam);

    JdbcUtils.Param poToJdbcParam(DatasourceEntity datasource);
}
