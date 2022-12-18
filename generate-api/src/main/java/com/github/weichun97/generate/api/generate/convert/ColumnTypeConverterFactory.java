package com.github.weichun97.generate.api.generate.convert;

import com.github.weichun97.generate.api.var.GenerateVar;

import java.util.HashMap;
import java.util.Map;

public class ColumnTypeConverterFactory {

    private static final Map<Integer, ColumnTypeConverter> CONTEXT = new HashMap<>();

    private static final ColumnTypeConverter NULL = new NullColumnTypeConverter();

    /**
     * 注册
     *
     * @param type 模板类型{@link GenerateVar.LangConverterType}
     * @param columnTypeConverter
     */
    public static void register(Integer type, ColumnTypeConverter columnTypeConverter){
        CONTEXT.put(type, columnTypeConverter);
    }

    /**
     * 根据消息 id 获取消息
     *
     * @param type 数据库类型{@link GenerateVar.LangConverterType}
     * @return message
     */
    public static ColumnTypeConverter get(Integer type){
        return CONTEXT.getOrDefault(type, NULL);
    }
}
