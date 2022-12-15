package com.github.weichun97.generate.api.var;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public interface DatasourceVar {

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
                .put(MYSQL, "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .build()
                ;

        Map<Integer, String> DRIVER = MapUtil.<Integer, String>builder()
                .put(MYSQL, "com.mysql.cj.jdbc.Driver")
                .build()
                ;
    }

}
