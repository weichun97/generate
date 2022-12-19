package com.github.weichun97.generate.api.generate;

import com.google.common.base.CaseFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableDTO {

    /**
     * 原始表名
     */
    private String name;

    /**
     * 表名-全小写
     */
    private String nameLower;

    /**
     * 表名-小驼峰
     */
    private String nameLowerCamel;

    /**
     * 表名-大驼峰
     */
    private String nameUpperCamel;

    /**
     * 表名-小写中划线
     */
    private String nameLowerHyphen;

    /**
     * 表名-小写下划线
     */
    private String nameLowerUnderscore;

    /**
     * 表名-大写下划线
     */
    private String nameUpperUnderscore;

    /**
     * 表备注
     */
    private String comment;
}
