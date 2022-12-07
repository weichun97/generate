package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam")
public class SaveOrUpdateParam {

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称", example = "mapper")
    private String name;
}
