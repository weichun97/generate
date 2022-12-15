package com.github.weichun97.generate.api.pojo.param.generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 17:08
 */
@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.generate.GenerateReqVO")
public class GenerateParam {

    @NotEmpty(message = "请选择要生成代码的表")
    @ApiModelProperty(value = "表名", example = "[\"table1\", \"table2\"]")
    private List<String> tableNames;

    @NotEmpty(message = "请选择要生成模板")
    @ApiModelProperty(value = "模板id集合", example = "[1,2]")
    private List<Long> templateIds;

    @NotNull(message = "请选择数据源")
    @ApiModelProperty(value = "数据源", example = "1")
    private Long datasourceId;
}
