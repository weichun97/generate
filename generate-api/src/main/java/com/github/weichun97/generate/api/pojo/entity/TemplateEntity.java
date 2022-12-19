package com.github.weichun97.generate.api.pojo.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("tl_template")
@NoArgsConstructor
@AllArgsConstructor
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
   * 自定义字段
   */
  private String customField;

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
