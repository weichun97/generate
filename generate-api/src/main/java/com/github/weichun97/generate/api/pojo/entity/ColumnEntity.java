package com.github.weichun97.generate.api.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 列的属性
 */
@Data
@TableName("COLUMNS")
public class ColumnEntity implements Serializable {
    private static final long serialVersionUID = 432741612412735329L;

    /**
     * 表名
     */
    @TableField("TABLE_NAME")
    private String tableName;

    /**
     * 列名
     */
    @TableField("COLUMN_NAME")
    private String columnName;

    /**
     * 列名类型
     */
    @TableField("DATA_TYPE")
    private String dataType;

    /**
     * 列名备注
     */
    @TableField("COLUMN_COMMENT")
    private String columnComment;
}
