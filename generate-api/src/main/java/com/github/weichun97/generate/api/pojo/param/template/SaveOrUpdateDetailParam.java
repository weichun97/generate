package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.UpdateDetailParam")
public class SaveOrUpdateDetailParam {

    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", example = "1")
    private Long templateId;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称", example = "mapper")
    private String name;

    @NotBlank(message = "模板内容不能为空")
    @ApiModelProperty(value = "模板内容", example = "")
    private String content;

    @Length(max = 20, message = "文件后缀长度不能超过20")
    @ApiModelProperty(value = "文件后缀", example = "Mapper.java")
    private String suffix;

    @Length(max = 50, message = "文件后缀长度不能超过50")
    @ApiModelProperty(value = "文件目录", example = "module/user")
    private String dir;
}
