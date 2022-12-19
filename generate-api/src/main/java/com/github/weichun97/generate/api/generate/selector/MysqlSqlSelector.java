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
        String baseSql = String.format("select TABLE_NAME, TABLE_COMMENT from information_schema.tables where table_schema='%s' and table_type='base table'", dbName);
        if(CollUtil.isNotEmpty(tableNames)){
            baseSql += " and TABLE_NAME in (";
            for (String tableName : tableNames) {
                baseSql += "\""+tableName+"\",";
            }
            baseSql = baseSql.substring(0, baseSql.length() - 1);
            baseSql += ")";
        }
        baseSql += ";";

        return mapToTableDto(sqlRunner.selectAll(baseSql), delPrefix);
    }

    private List<TableDTO> mapToTableDto(List<Map<String, Object>> maps, String delPrefix) {
        List<String> delPrefixs = Collections.emptyList();
        if(StrUtil.isNotBlank(delPrefix)){
            delPrefixs = StrUtil.split(delPrefix, ",");
        }
        List<TableDTO> tableDTOS = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            String originTableName = map.get("TABLE_NAME").toString();
            String tableName = JdbcUtils.removePrefix(originTableName, delPrefixs);
            tableDTOS.add(TableDTO.builder()
                    .name(originTableName)
                    .nameLower(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName).toLowerCase())
                    .nameLowerCamel(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName))
                    .nameUpperCamel(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName))
                    .nameLowerHyphen(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, tableName))
                    .nameLowerUnderscore(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, tableName))
                    .nameUpperUnderscore(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, tableName))
                    .comment(map.get("TABLE_COMMENT").toString())
                    .build());
        }
        return tableDTOS;
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

    private List<ColumnDTO> mapToColumnDto(List<Map<String, Object>> maps) {
        List<ColumnDTO> columnDTOS = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            String columnName = map.get("COLUMN_NAME").toString();
            columnDTOS.add(ColumnDTO.builder()
                    .tableName(map.get("TABLE_NAME").toString())
                    .name(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName))
                    .nameLowerCamel(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName))
                    .nameUpperCamel(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, columnName))
                    .nameLowerHyphen(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, columnName))
                    .nameLowerUnderscore(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, columnName))
                    .nameUpperUnderscore(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, columnName))
                    .comment(map.get("COLUMN_COMMENT").toString())
                    .type(map.get("DATA_TYPE").toString())
                    .primaryFlag(Integer.valueOf(map.get("PRIMARY_FLAG").toString()))
                    .autoFlag(Integer.valueOf(map.get("AUTO_FLAG").toString()))
                    .build());
        }
        return columnDTOS;
    }

    /**
     * 字符串数组转成 mysql 的 in 格式<br/>
     * 例如：数组 ["user", "role"] 转换成字符串 "user","role"
     * @return
     */
    private String formatInStr(List<String> list){
        if (CollUtil.isEmpty(list)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            stringBuilder.append("\"").append(str).append("\",");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }
}
