package com.github.weichun97.generate.api.pojo.vo.template;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam")
public class TemplateQueryVO {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "模板名", example = "默认")
    private String name;

    @ApiModelProperty(value = "根目录", example = "com/itran/fgoc/server")
    private String baseDir;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_MINUTE_PATTERN)
    @ApiModelProperty(value = "创建时间", example = "2022-01-01")
    private Date createTime;
}
