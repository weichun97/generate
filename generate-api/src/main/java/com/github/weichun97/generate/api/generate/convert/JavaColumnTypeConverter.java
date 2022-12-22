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
            .put(TINYBLOB, "byte[]")
            .put(BLOB, "byte[]")
            .put(MEDIUMBLOB, "byte[]")
            .put(LONGBLOB, "byte[]")
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
            .put(TINYBLOB, "Byte[]")
            .put(BLOB, "Byte[]")
            .put(MEDIUMBLOB, "Byte[]")
            .put(LONGBLOB, "Byte[]")
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
