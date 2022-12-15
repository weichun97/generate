package com.github.weichun97.generate.api.pojo.vo.generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chun
 * @date 2020/8/12 15:47
 */
@Data
@ApiModel("com.github.weichun97.generate.api.pojo.vo.generate.TablesVO")
public class TablesVO {

    @ApiModelProperty(value = "表名", example = "demo")
    private String name;

    @ApiModelProperty(value = "备注", example = "测试")
    private String comment;
}
