package com.github.weichun97.generate.api.generate;

import org.springframework.beans.factory.InitializingBean;

public interface SqlSelector  extends InitializingBean {

    /**
     * 获取数据库类型
     * @see com.github.weichun97.generate.api.var.DatasourceVar.DbType
     * @return
     */
    int getDbType();

    /**
     * 获取表名信息的 sql
     * @return
     */
    String showTablesSql(String database);

    @Override
    default void afterPropertiesSet() throws Exception{
        SqlSelectorFactory.register(getDbType(), this);
    }
}
