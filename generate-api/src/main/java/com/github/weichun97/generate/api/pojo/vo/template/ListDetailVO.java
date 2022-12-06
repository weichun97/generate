package com.github.weichun97.generate.api.pojo.vo.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.vo.template.ListDetailByIdVO")
public class ListDetailVO {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "名称", example = "mapper")
    private String name;

    @ApiModelProperty(value = "模板内容", example = "")
    private String content;

    @ApiModelProperty(value = "文件后缀", example = "Mapper.java")
    private String suffix;

    @ApiModelProperty(value = "文件目录", example = "module/user")
    private String dir;
}
