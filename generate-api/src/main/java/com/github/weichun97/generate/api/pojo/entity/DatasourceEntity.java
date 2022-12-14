package com.github.weichun97.generate.api.pojo.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.github.weichun97.generate.api.var.DatasourceVar;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tl_datasource")
public class DatasourceEntity {

  /**
   * id
   */
  @TableId(type = IdType.AUTO)
  private Long id;

  /**
   * 主机
   */
  private String host;

  /**
   * 端口号
   */
  private Long port;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 数据库名
   */
  private String dbName;

  /**
   * 数据库类型
   * @see DatasourceVar.DbType
   */
  private Integer dbType;

  /**
   * 删除表前缀
   */
  private String delPrefix;

  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * 更新时间
   */
  @TableField(fill = FieldFill.UPDATE)
  private Date updateTime;

  /**
   * 删除时间
   */
  @TableLogic(value = "null", delval = "now()")
  private Date deleteTime;
}
