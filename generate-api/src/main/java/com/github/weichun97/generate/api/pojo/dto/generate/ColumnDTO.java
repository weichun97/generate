package com.github.weichun97.generate.api.pojo.dto.generate;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chun
 * @date 2020/8/13 14:12
 */
@Data
public class ColumnDTO implements Serializable {
    private static final long serialVersionUID = -6906807865346733901L;

    /**
     * 数据库列
     */
    private String oldColumnName;

    /**
     * 列名，小驼峰
     */
    private String columnName;

    /**
     * 列名类型 转换成了 java 包装类型
     */
    private String javaType;

    /**
     * 列名备注
     */
    private String columnComment;
}
