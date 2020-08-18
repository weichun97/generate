package com.github.weichun97.generate.api.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 表数据
 */
@Data
@TableName("TABLES")
public class TableEntity implements Serializable {

	private static final long serialVersionUID = 3318995681787530341L;

	/**
	 * 表名
	 */
	@TableField("TABLE_NAME")
	private String tableName;

	/**
	 * 引擎
	 */
	@TableField("ENGINE")
	private String engine;

	/**
	 * 备注
	 */
	@TableField("TABLE_COMMENT")
	private String tableComment;

	/**
	 * 编码
	 */
	@TableField("TABLE_COLLATION")
	private String tableCollation;
}
