package com.github.weichun97.generate.api.pojo.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tl_template")
public class TemplateEntity {

  /**
   * id
   */
  @TableId(type = IdType.AUTO)
  private Long id;

  /**
   * 姓名
   */
  private String name;

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
