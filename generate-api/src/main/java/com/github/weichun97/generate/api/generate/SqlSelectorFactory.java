package com.github.weichun97.generate.api.generate;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Message factory.
 *
 * @author chun
 * @date 2021 /8/18 11:00
 */
public class SqlSelectorFactory {

    /**
     * 消息类型容器
     */
    private static final Map<Integer, SqlSelector> CONTEXT = new HashMap<>();

    /**
     * 空对象
     */
    private static final NullSqlSelector NULL = new NullSqlSelector();

    /**
     * 注册
     *
     * @param dbType 数据库类型{@link com.github.weichun97.generate.api.var.DatasourceVar.DbType}
     * @param sqlSelector   the message
     */
    public static void register(Integer dbType, SqlSelector sqlSelector){
        CONTEXT.put(dbType, sqlSelector);
    }

    /**
     * 根据消息 id 获取消息
     *
     * @param dbType 数据库类型{@link com.github.weichun97.generate.api.var.DatasourceVar.DbType}
     * @return message
     */
    public static SqlSelector get(Integer dbType){
        return CONTEXT.getOrDefault(dbType, NULL);
    }
}
