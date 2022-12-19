package com.github.weichun97.generate.api.generate.convert;

import cn.hutool.core.map.MapUtil;
import com.github.weichun97.generate.api.var.GenerateVar;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.github.weichun97.generate.api.var.DatasourceVar.DataType.*;

@Getter
@Component
public class JavaColumnTypeConverter implements ColumnTypeConverter {

    private final int type = GenerateVar.LangConverterType.JAVA;

    private static final Map<String, String> JAVA_TYPE = MapUtil.<String, String>builder()
            // 数字
            .put(TINYINT, "int")
            .put(SMALLINT, "int")
            .put(MEDIUMINT, "int")
            .put(INT, "int")
            .put(INTEGER, "int")
            .put(BIGINT, "long")
            .put(FLOAT, "float")
            .put(DOUBLE, "double")
            .put(DECIMAL, "BigDecimal")
            // 字符串
            .put(BIT, "String")
            .put(CHAR, "String")
            .put(VARCHAR, "String")
            .put(TINYBLOB, "byte[]")
            .put(TINYTEXT, "String")
            .put(BLOB, "byte[]")
            .put(TEXT, "String")
            .put(MEDIUMBLOB, "byte[]")
            .put(MEDIUMTEXT, "String")
            .put(LONGBLOB, "byte[]")
            .put(LONGTEXT, "String")
            // 日期
            .put(DATE, "Date")
            .put(TIME, "Date")
            .put(YEAR, "Date")
            .put(DATETIME, "Date")
            .put(TIMESTAMP, "Date")
            .build()
            ;

    private static final Map<String, String> JAVA_BOX_TYPE = MapUtil.<String, String>builder()
            // 数字
            .put(TINYINT, "Integer")
            .put(SMALLINT, "Integer")
            .put(MEDIUMINT, "Integer")
            .put(INT, "Integer")
            .put(INTEGER, "Integer")
            .put(BIGINT, "Long")
            .put(FLOAT, "Float")
            .put(DOUBLE, "Double")
            .put(DECIMAL, "BigDecimal")
            // 字符串
            .put(BIT, "String")
            .put(CHAR, "String")
            .put(VARCHAR, "String")
            .put(TINYBLOB, "Byte[]")
            .put(TINYTEXT, "String")
            .put(BLOB, "Byte[]")
            .put(TEXT, "String")
            .put(MEDIUMBLOB, "Byte[]")
            .put(MEDIUMTEXT, "String")
            .put(LONGBLOB, "Byte[]")
            .put(LONGTEXT, "String")
            // 日期
            .put(DATE, "Date")
            .put(TIME, "Date")
            .put(YEAR, "Date")
            .put(DATETIME, "Date")
            .put(TIMESTAMP, "Date")
            .build()
            ;

    @Override
    public String convertType(String type) {
        return JAVA_TYPE.getOrDefault(type, "String");
    }

    @Override
    public String convertTypeBox(String type) {
        return JAVA_BOX_TYPE.getOrDefault(type, "String");
    }
}
