package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam;
import com.github.weichun97.generate.common.api.SelectVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TemplateMapper {

    TemplateEntity saveOrUpdateParamToPo(SaveOrUpdateParam saveOrUpdateParam);
    SelectVO poToSelectVo(TemplateEntity templateEntity);
    List<SelectVO> poToSelectVo(List<TemplateEntity> templateEntities);
}
