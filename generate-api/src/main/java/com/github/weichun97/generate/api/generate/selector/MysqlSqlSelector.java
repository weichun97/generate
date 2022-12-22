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
public class MysqlSqlSelector implements SqlSelector{

    private final int dbType = DatasourceVar.DbType.MYSQL;

    @Resource
    private TableMapper tableMaps;

    @Override
    public List<TableDTO> listTableInfo(SqlRunner sqlRunner, String dbName, @Nullable List<String> tableNames, String delPrefix) throws SQLException {
        String baseSql = "select TABLE_NAME, TABLE_COMMENT " +
                "from information_schema.tables " +
                "where table_schema='%s' " +
                "and table_type='base table' " +
                "%s;"
                ;
        String tableNameSql = "";
        if(CollUtil.isNotEmpty(tableNames)){
            tableNameSql = String.format("and TABLE_NAME in (%s)", String.join(",", formatInStr(tableNames)));
        }
        return mapToTableDto(sqlRunner.selectAll(String.format(baseSql, dbName, tableNameSql)), delPrefix);
    }

    @Override
    public List<ColumnDTO> listColumnInfo(SqlRunner sqlRunner, String dbName, @Nullable List<String> tableNames) throws SQLException {
        String sqlFormatStr = "select " +
                " table_name, column_name, data_type,  " +
                " case " +
                "  column_key  " +
                "  when 'PRI' then 1 " +
                "  else 0 " +
                " end primary_flag, " +
                " case " +
                "  extra  " +
                "  when 'auto_increment' then 1 " +
                "  else 0 " +
                " end auto_flag, " +
                " column_comment " +
                "from INFORMATION_SCHEMA.COLUMNS " +
                "where TABLE_SCHEMA = '%s' " +
                " %s;";
        String tableNameSql = null;
        if(CollUtil.isNotEmpty(tableNames)){
            tableNameSql = String.format("AND TABLE_NAME in (%s)", formatInStr(tableNames));
        }
        return mapToColumnDto(sqlRunner.selectAll(String.format(sqlFormatStr, dbName, tableNameSql)));
    }
}
