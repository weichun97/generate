package com.github.weichun97.generate.api.generate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDTO {

    /**
     * 原始表名
     */
    private String tableName;

    /**
     * 原始字段名
     */
    private String name;

    /**
     * 字段名-小驼峰
     */
    private String nameLowerCamel;

    /**
     * 字段名-大驼峰
     */
    private String nameUpperCamel;

    /**
     * 字段名-小写中划线
     */
    private String nameLowerHyphen;

    /**
     * 字段名-小写下划线
     */
    private String nameLowerUnderscore;

    /**
     * 字段名-大写下划线
     */
    private String nameUpperUnderscore;

    /**
     * 备注
     */
    private String comment;

    /**
     * 数据库类型
     */
    private String type;

    /**
     * 基础类型
     */
    private String baseType;

    /**
     * 包装类型
     */
    private String boxType;

    /**
     * 是否主键
     */
    private Integer primaryFlag;

    /**
     * 是否自增
     */
    private Integer autoFlag;
}
