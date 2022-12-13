package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.ListDetailParam")
public class ListDetailParam {

    @ApiModelProperty(value = "id", example = "模板组id")
    private Long id;
}
