package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TemplateDetailMapper {

    ListDetailVO poToListDetailByIdVo(TemplateDetailEntity templateDetailEntity);
    List<ListDetailVO> poToListDetailByIdVo(List<TemplateDetailEntity> templateDetailEntities);

    TemplateDetailEntity saveOrUpdateDetailParamToPo(SaveOrUpdateDetailParam saveOrUpdateDetailParam);
}
