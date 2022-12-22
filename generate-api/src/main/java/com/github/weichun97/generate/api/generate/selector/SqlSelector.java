package com.github.weichun97.generate.api.generate.selector;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.weichun97.generate.api.generate.ColumnDTO;
import com.github.weichun97.generate.api.generate.TableDTO;
import com.github.weichun97.generate.api.util.JdbcUtils;
import com.google.common.base.CaseFormat;
import org.apache.ibatis.jdbc.SqlRunner;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    default List<TableDTO> mapToTableDto(List<Map<String, Object>> maps, String delPrefix) {
        List<String> delPrefixArr = StrUtil.split(delPrefix, ",");
        List<TableDTO> tableDTOS = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            String originTableName = map.get("TABLE_NAME").toString();
            String tableName = JdbcUtils.removePrefix(originTableName, delPrefixArr);
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

    default List<ColumnDTO> mapToColumnDto(List<Map<String, Object>> maps) {
        List<ColumnDTO> columnDTOS = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            String columnName = map.get("COLUMN_NAME").toString();
            columnDTOS.add(ColumnDTO.builder()
                    .tableName(map.get("TABLE_NAME").toString())
                    .name(columnName)
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
    default String formatInStr(List<String> list){
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
