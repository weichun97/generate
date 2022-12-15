package com.github.weichun97.generate.api.generate;

import com.github.weichun97.generate.api.var.DatasourceVar;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MysqlSqlSelector implements SqlSelector{

    private final int dbType = DatasourceVar.DbType.MYSQL;

    @Override
    public String showTablesSql(String dbName) {
        return String.format("select TABLE_NAME name, TABLE_COMMENT comment  from information_schema.tables where table_schema='%s' and table_type='base table';", dbName);
    }
}
