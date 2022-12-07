package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam;
import org.mapstruct.Mapper;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TemplateMapper {

    TemplateEntity saveOrUpdateParamToPo(SaveOrUpdateParam saveOrUpdateParam);
}
