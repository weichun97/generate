package com.chun.generate.common.util;

import cn.hutool.core.map.MapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/13 14:29
 */
public class TableUtils {

    private static Map<String, String> columnMap;


    static {
        columnMap = new HashMap<>(16);
        columnMap.put("tinyint", "Integer");
        columnMap.put("smallint", "Integer");
        columnMap.put("mediumint", "Integer");
        columnMap.put("int", "Integer");
        columnMap.put("integer", "Integer");
        columnMap.put("bigint", "Long");
        columnMap.put("float", "Double");
        columnMap.put("double", "Double");
        columnMap.put("decimal", "Double");

        columnMap.put("bit", "String");
        columnMap.put("char", "String");
        columnMap.put("varchar", "String");
        columnMap.put("tinytext", "String");
        columnMap.put("text", "String");
        columnMap.put("mediumtext", "String");
        columnMap.put("longtext", "String");

        columnMap.put("date", "Date");
        columnMap.put("datetime", "Date");
        columnMap.put("timestamp", "Date");
    }

    /**
     * 数据库字段类型转换成 java 类型
     * @param cloumn 数据库字段类型
     * @return java 类型
     */
    public static String cloumnTypeToStr(String cloumn){
        return columnMap.containsKey(cloumn) ? columnMap.get(cloumn) : "String";
    }
}
