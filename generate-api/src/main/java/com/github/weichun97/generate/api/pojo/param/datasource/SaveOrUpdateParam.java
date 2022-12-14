package com.github.weichun97.generate.api.pojo.param.datasource;

import com.github.weichun97.generate.api.var.DatasourceVar;
import com.github.weichun97.generate.common.swagger.ApiModelEnumProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.param.datasource.SaveOrUpdateParam")
public class SaveOrUpdateParam {

    @NotBlank(message = "主机不能为空")
    @ApiModelProperty(value = "主机", example = "127.0.0.1")
    private String host;

    @NotNull(message = "端口号不能为空")
    @ApiModelProperty(value = "端口号", example = "3306")
    private Long port;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", example = "root")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", example = "root")
    private String password;

    @NotBlank(message = "数据库名不能为空")
    @ApiModelProperty(value = "数据库名", example = "test")
    private String dbName;

    @NotNull(message = "数据库类型不能为空")
    @ApiModelEnumProperty(enumClass = DatasourceVar.DbType.class, value = "数据库类型", example = "1")
    private Integer dbType;

    @ApiModelProperty(value = "删除表前缀,多个用逗号隔开", example = "ts_,tl_")
    private String delPrefix;
}
