package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.UpdateCustomFieldsParam")
public class UpdateCustomFieldsParam {

    @ApiModelProperty(value = "自定义字段, key-value格式的json", example = "")
    private String customField;
}
