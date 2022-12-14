package com.github.weichun97.generate.api.var;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public interface DatasourceVar {

    /**
     * 数据类型
     */
    interface DbType{
        int MYSQL = 1;

        Map<Object, Object> MSG = MapUtil.builder()
                .put(MYSQL, "mysql")
                .build()
                ;
    }

}
