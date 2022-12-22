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
        // mysql
        String TINYINT = "tinyint";
        String SMALLINT = "smallint";
        String MEDIUMINT = "mediumint";
        String INT = "int";
        String INTEGER = "integer";
        String BIGINT = "bigint";
        String FLOAT = "float";
        String DOUBLE = "double";
        String DECIMAL = "decimal";
        // pgsql
        String BIGSERIAL = "bigserial";
        String BOOLEAN = "boolean";
        String DOUBLE_PRECISION = "double precision";
        String MONEY = "money";
        String numeric = "numeric";
        String PG_LSN = "pg_lsn";
        String SMALLSERIAL = "smallserial";
        String SERIAL = "serial";

        /**
         * 字符串类型
         */
        // mysql
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
        // pgsql
        String BYTEA = "bytea";

        /**
         * 日期类型
         */
        // mysql
        String DATE = "date";
        String TIME = "time";
        String YEAR = "year";
        String DATETIME = "datetime";
        String TIMESTAMP = "timestamp";
        String TIME_WITH_TIME_ZONE = "time with time zone";
        String TIME_WITHOUT_TIME_ZONE = "time without time zone";
        String TIMESTAMP_WITH_TIME_ZONE = "timestamp with time zone";
        String TIMESTAMP_WITHOUT_TIME_ZONE = "timestamp without time zone";
    }

    /**
     * 数据类型
     */
    interface DbType{
        int NULL = 0;
        int MYSQL = 1;
        int POSTGRESQL = 2;

        Map<Object, Object> MSG = MapUtil.builder()
                .put(MYSQL, "mysql")
                .put(POSTGRESQL, "postgresql")
                .build()
                ;

        Map<Integer, String> JDBC_URL = MapUtil.<Integer, String>builder()
                .put(MYSQL, "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false")
                .put(POSTGRESQL, "jdbc:postgresql://%s:%s/%s")
                .build()
                ;

        Map<Integer, String> DRIVER = MapUtil.<Integer, String>builder()
                .put(MYSQL, "com.mysql.cj.jdbc.Driver")
                .put(POSTGRESQL, "org.postgresql.Driver")
                .build()
                ;
    }

}
