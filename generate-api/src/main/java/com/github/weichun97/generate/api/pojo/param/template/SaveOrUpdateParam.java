package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam")
public class SaveOrUpdateParam {

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称", example = "mapper")
    private String name;

    @Pattern(regexp = "^([a-zA-Z_]+[a-zA-Z0-9_]*[a-zA-Z_]*)*(/?[a-zA-Z_]+[a-zA-Z0-9_]*[a-zA-Z_]*)+$", message = "根目录格式不正确")
    @ApiModelProperty(value = "根目录", example = "mapper")
    private String baseDir;

    @ApiModelProperty(value = "备注", example = "")
    private String remark;
}
