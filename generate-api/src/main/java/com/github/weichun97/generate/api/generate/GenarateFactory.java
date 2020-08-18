package com.github.weichun97.generate.api.generate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/13 11:23
 */
public class GenarateFactory {

    /**
     * 类模板文件标识
     */
    public static final String CLASS_GENERATE_KEY = "class";

    /**
     * 资源模板文件标识
     */
    public static final String RESOURCE_GENERATE_KEY = "resource";

    /**
     * 容器
     */
    private static Map<String, Generate> CONTEXT = new HashMap<>();

    /**
     * 获取
     * @param type
     * @return
     */
    public static Generate get(String type){
        return CONTEXT.get(type);
    }

    /**
     * 注册
     * @param generate
     */
    public static void regist(String type, Generate generate){
        CONTEXT.put(type, generate);
    }
}
