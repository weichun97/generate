package com.github.weichun97.generate.api.util;

import cn.hutool.core.util.StrUtil;
import com.github.weichun97.generate.api.var.DatasourceVar;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.exception.ApiException;
import com.github.weichun97.generate.common.exception.BizAssert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JdbcUtils {

    /**
     * 获取数据库连接
     * @param param
     * @return
     * @throws SQLException
     */
    public static Connection getConnect(Param param) {
        try {
            Connection connection = DriverManager.getConnection(getJdbcUrl(param), param.getUsername(), param.getPassword());
            BizAssert.assertNotNull(connection, ResultCode.CODE_10003);
            return connection;
        }catch (SQLException e){
            throw new ApiException(ResultCode.CODE_10003, String.format("数据库连接失败,%s", e.getMessage()));
        }
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ApiException(ResultCode.CODE_10003, String.format("数据库关闭连接失败,%s", e.getMessage()));
        }
    }

    /**
     * 获取
     * @param param
     * @return
     */
    private static String getJdbcUrl(Param param){
        String jdbcUrlStr = DatasourceVar.DbType.JDBC_URL.get(param.getDbType());
        BizAssert.assertNotBlank(jdbcUrlStr, ResultCode.CODE_10002);
        return String.format(DatasourceVar.DbType.JDBC_URL.get(param.getDbType()), param.getHost(), param.getPort(), param.getDbName());
    }

    /**
     * 删除表前缀
     * @param tableName 表名
     * @param prefixs 前缀列表
     * @return
     */
    public static String removePrefix(String tableName, List<String> prefixs){
        for (int i = 0; i < prefixs.size(); i++) {
            if(tableName.startsWith(prefixs.get(i))){
                tableName = StrUtil.removePrefix(tableName, prefixs.get(i));
                break;
            }
        }
        return tableName;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Param {

        private String host;

        /**
         * @see DatasourceVar.DbType
         */
        private Integer dbType;

        private String port;

        private String username;

        private String password;

        private String dbName;
    }
}
