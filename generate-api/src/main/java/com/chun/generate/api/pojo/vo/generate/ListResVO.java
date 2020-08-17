package com.chun.generate.api.pojo.vo.generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chun
 * @date 2020/8/12 15:47
 */
@Data
@ApiModel("com.chun.generate.api.pojo.vo.table.ListResVO")
public class ListResVO implements Serializable {

    private static final long serialVersionUID = -3630421850867997134L;

    @ApiModelProperty(value = "表名", example = "demo")
    private String tableName;

    @ApiModelProperty(value = "表引擎", example = "InnoDB")
    private String engine;

    @ApiModelProperty(value = "备注", example = "测试")
    private String tableComment;

    @ApiModelProperty(value = "字符集", example = "utf8_general_ci")
    private String tableCollation;
}
