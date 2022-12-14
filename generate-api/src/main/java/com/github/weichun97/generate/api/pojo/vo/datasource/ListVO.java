package com.github.weichun97.generate.api.pojo.vo.datasource;

import com.github.weichun97.generate.api.var.DatasourceVar;
import com.github.weichun97.generate.common.swagger.ApiModelEnumProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("com.github.weichun97.generate.api.pojo.vo.datasource.ListVO")
public class ListVO {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "主机", example = "127.0.0.1")
    private String host;

    @ApiModelProperty(value = "端口号", example = "3306")
    private Long port;

    @ApiModelProperty(value = "用户名", example = "root")
    private String username;

    @ApiModelProperty(value = "密码", example = "root")
    private String password;

    @ApiModelProperty(value = "数据库名", example = "test")
    private String dbName;

    @ApiModelEnumProperty(enumClass = DatasourceVar.DbType.class, value = "数据库类型", example = "1")
    private Integer dbType;

    @ApiModelProperty(value = "删除表前缀,多个用逗号隔开", example = "ts_,tl_")
    private String delPrefix;
}
