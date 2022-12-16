package com.github.weichun97.generate.api.pojo.vo.generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("com.github.weichun97.generate.api.pojo.vo.generate.GenerateVO")
public class GenerateVO {

    @ApiModelProperty(value = "文件夹货文件名", example = "entity")
    private String dirOrFileName;

    @ApiModelProperty(value = "文件内容", example = "public class User{}")
    private String content;

    @ApiModelProperty("文件内容")
    private List<GenerateVO> children;
}
