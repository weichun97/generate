package com.github.weichun97.generate.api.pojo.vo.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.vo.template.CustomFieldVO")
public class CustomFieldVO {

    @NotBlank(message = "键不能为空")
    @ApiModelProperty(value = "键", example = "name")
    private String key;

    @NotBlank
    @ApiModelProperty(value = "值", example = "张三")
    private String value;
}
