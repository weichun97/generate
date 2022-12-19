package com.github.weichun97.generate.api.pojo.param.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam")
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

    @Length(max = 100, message = "文件名长度不能超过100")
    @ApiModelProperty(value = "文件名", example = "Mapper.java")
    private String fileName;

    @Length(max = 200, message = "文件后缀长度不能超过200")
    @ApiModelProperty(value = "文件目录", example = "module/user")
    private String dir;
}
