package com.github.weichun97.generate.api.pojo.param.template;

import com.github.weichun97.generate.api.var.DatasourceVar;
import com.github.weichun97.generate.common.swagger.ApiModelEnumProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.ListDetailParam")
public class ListDetailParam {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "模板名", example = "controller")
    private String name;
}
