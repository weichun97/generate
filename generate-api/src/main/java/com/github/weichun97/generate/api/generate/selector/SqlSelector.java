package com.github.weichun97.generate.api.generate.selector;

import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.TableDTO;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

import java.sql.SQLException;
import java.util.List;

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
    List<TableDTO> listTableInfo(SqlRunner sqlRunner, String database, @Nullable List<String> tableNames, String delPrefix) throws SQLException;

    List<ColumnDTO> listColumnInfo(SqlRunner sqlRunner, String dbName, @Nullable List<String> tableNames) throws SQLException;

    @Override
    default void afterPropertiesSet() throws Exception{
        SqlSelectorFactory.register(getDbType(), this);
    }
}
