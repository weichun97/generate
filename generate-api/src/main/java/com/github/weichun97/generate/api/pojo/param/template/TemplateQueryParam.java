package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam")
public class TemplateQueryParam {

    @ApiModelProperty(value = "模板名", example = "默认")
    private String name;
}
