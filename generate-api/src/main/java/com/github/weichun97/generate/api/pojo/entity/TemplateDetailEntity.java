package com.github.weichun97.generate.api.pojo.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tl_template_detail")
public class TemplateDetailEntity {

  /**
   * id
   */
  @TableId(type = IdType.AUTO)
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 模板内容
   */
  private String content;

  /**
   * 文件名
   */
  private String fileName;

  /**
   * 文件目录
   */
  private String dir;

  /**
   * 模板 id
   */
  private Long templateId;

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
