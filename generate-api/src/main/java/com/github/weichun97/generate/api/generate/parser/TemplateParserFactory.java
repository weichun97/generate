package com.github.weichun97.generate.api.generate.parser;

import com.github.weichun97.generate.api.var.GenerateVar;

import java.util.HashMap;
import java.util.Map;

public class TemplateParserFactory {

    private static final Map<Integer, TemplateParser> CONTEXT = new HashMap<>();

    private static final NullTemplateParser NULL = new NullTemplateParser();

    /**
     * 注册
     *
     * @param type 模板类型{@link GenerateVar.TemplateType}
     * @param templateParser
     */
    public static void register(Integer type, TemplateParser templateParser){
        CONTEXT.put(type, templateParser);
    }

    /**
     * 根据消息 id 获取消息
     *
     * @param type 数据库类型{@link GenerateVar.TemplateType}
     * @return message
     */
    public static TemplateParser get(Integer type){
        return CONTEXT.getOrDefault(type, NULL);
    }
}
