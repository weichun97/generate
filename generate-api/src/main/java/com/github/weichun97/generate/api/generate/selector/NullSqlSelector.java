package com.github.weichun97.generate.api.generate.selector;

import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.TableDTO;
import com.github.weichun97.generate.api.var.DatasourceVar;
import lombok.Data;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Data
@Component
public class NullSqlSelector implements SqlSelector{

    private final int dbType = DatasourceVar.DbType.NULL;

    @Override
    public List<TableDTO> listTableInfo(SqlRunner sqlRunner, String database, List<String> tableNames, String delPrefix) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<ColumnDTO> listColumnInfo(SqlRunner sqlRunner, String dbName, List<String> tableNames) throws SQLException {
        return Collections.emptyList();
    }
}
