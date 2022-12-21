package com.github.weichun97.generate.api.var;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public interface DatasourceVar {

    /**
     * 数据库字段类型
     */
    interface DataType {
        /**
         * 数字类型
         */
        String TINYINT = "tinyint";
        String SMALLINT = "smallint";
        String MEDIUMINT = "mediumint";
        String INT = "int";
        String INTEGER = "integer";
        String BIGINT = "bigint";
        String FLOAT = "float";
        String DOUBLE = "double";
        String DECIMAL = "decimal";

        /**
         * 字符串类型
         */
        String BIT = "bit";
        String CHAR = "char";
        String VARCHAR = "varchar";
        String TINYBLOB = "tinyblob";
        String TINYTEXT = "tinytext";
        String BLOB = "blob";
        String TEXT = "text";
        String MEDIUMBLOB = "mediumblob";
        String MEDIUMTEXT = "mediumtext";
        String LONGBLOB = "longblob";
        String LONGTEXT = "longtext";

        /**
         * 日期类型
         */
        String DATE = "date";
        String TIME = "time";
        String YEAR = "year";
        String DATETIME = "datetime";
        String TIMESTAMP = "timestamp";
    }

    /**
     * 数据类型
     */
    interface DbType{
        int NULL = 0;
        int MYSQL = 1;

        Map<Object, Object> MSG = MapUtil.builder()
                .put(MYSQL, "mysql")
                .build()
                ;

        Map<Integer, String> JDBC_URL = MapUtil.<Integer, String>builder()
                .put(MYSQL, "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false")
                .build()
                ;

        Map<Integer, String> DRIVER = MapUtil.<Integer, String>builder()
                .put(MYSQL, "com.mysql.cj.jdbc.Driver")
                .build()
                ;
    }

}
