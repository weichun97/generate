package com.github.weichun97.generate.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.common.api.SelectVO")
public class SelectVO {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "值", example = "测试")
    private String name;
}
