package com.github.weichun97.generate.api.generate.selector;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.TableDTO;
import com.github.weichun97.generate.api.pojo.mapper.TableMapper;
import com.github.weichun97.generate.api.util.JdbcUtils;
import com.github.weichun97.generate.api.var.DatasourceVar;
import com.google.common.base.CaseFormat;
import lombok.Data;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@Component
public class PostgreSqlSelector implements SqlSelector{

    private final int dbType = DatasourceVar.DbType.MYSQL;

    @Resource
    private TableMapper tableMaps;

    @Override
    public List<TableDTO> listTableInfo(SqlRunner sqlRunner, String dbName, @Nullable List<String> tableNames, String delPrefix) throws SQLException {
        String baseSql = "SELECT relname TABLE_NAME, obj_description(oid) TABLE_COMMENT " +
                "FROM pg_class " +
                "WHERE relkind='r' " +
                "AND relname NOT LIKE 'pg_%%' " +
                "AND relname NOT LIKE 'sql_%%' " +
                "AND relchecks=0 " +
                "%s " +
                "ORDER BY relname;";
        String tableNameSql = "";
        if(CollUtil.isNotEmpty(tableNames)){
            tableNameSql = String.format("AND relname IN (%s)", String.join(",", formatInStr(tableNames)));
        }

        return mapToTableDto(sqlRunner.selectAll(String.format(baseSql, tableNameSql)), delPrefix);
    }

    @Override
    public List<ColumnDTO> listColumnInfo(SqlRunner sqlRunner, String dbName, @Nullable List<String> tableNames) throws SQLException {
        String sqlFormatStr = "SELECT   " +
                " pg_class.relname as table_name, " +
                "  pg_attribute.attname AS column_name,   " +
                "  atttypid::regtype AS data_type,   " +
                " col_description ( pg_attribute.attrelid, pg_attribute.attnum ) AS column_comment,   " +
                " pg_attribute.attnum = pg_constraint.conkey [ 1 ] AS primary_flag,   " +
                " CASE WHEN POSITION ( 'nextval' IN column_default ) > 0 THEN 1 ELSE 0 END AS auto_flag   " +
                "FROM pg_constraint   " +
                "INNER JOIN pg_class ON pg_constraint.conrelid = pg_class.oid   " +
                "INNER JOIN pg_attribute ON pg_attribute.attrelid = pg_class.oid   " +
                "INNER JOIN pg_type ON pg_type.oid = pg_attribute.atttypid   " +
                "INNER JOIN information_schema.COLUMNS C ON C.TABLE_NAME = pg_class.relname    " +
                "  AND C.COLUMN_NAME = pg_attribute.attname    " +
                "WHERE pg_class.relname = '%s'    " +
                " %s " +
                "  AND pg_attribute.attnum > 0";
        String tableNameSql = null;
        if(CollUtil.isNotEmpty(tableNames)){
            tableNameSql = String.format("AND pg_class.relname in ('%s')", formatInStr(tableNames));
        }
        return mapToColumnDto(sqlRunner.selectAll(String.format(sqlFormatStr, dbName, tableNameSql)));
    }


}
