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

public class JdbcUtils {

    /**
     * 获取数据库连接
     * @param param
     * @return
     * @throws SQLException
     */
    public static Connection getConnect(Param param) {
        // TODO: 2022/12/15 测试不手动注入
//        registJdbcDriverClass(param.getDbType());
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
     * 根据数据库类型{@link DatasourceVar.DbType} 获取驱动类
     * @param dbType
     * @return
     */
    private static void registJdbcDriverClass(int dbType) throws ClassNotFoundException {
        String jdbcDriverClass = DatasourceVar.DbType.DRIVER.get(dbType);
        BizAssert.assertNotBlank(jdbcDriverClass, ResultCode.CODE_10001);
        Class.forName(jdbcDriverClass);
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
