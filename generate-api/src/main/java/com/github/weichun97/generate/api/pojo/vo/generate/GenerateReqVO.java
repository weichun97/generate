package com.github.weichun97.generate.api.pojo.vo.generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 17:08
 */
@Data
@ApiModel("com.github.weichun97.generate.api.pojo.vo.generate.GenerateReqVO")
public class GenerateReqVO implements Serializable {
    private static final long serialVersionUID = -1460735458852171951L;

    @NotEmpty(message = "请选择要生成代码的表")
    @ApiModelProperty(value = "表名", example = "user")
    private List<String> tableNames;

    @NotEmpty(message = "请选择要生成文件类型")
    @ApiModelProperty(value = "文件类型", example = "dao,service")
    private List<String> types;
}
