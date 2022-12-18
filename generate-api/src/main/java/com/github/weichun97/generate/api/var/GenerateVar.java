package com.github.weichun97.generate.api.var;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public interface GenerateVar {

    /**
     * 模板类型
     */
    interface TemplateType {
        int NULL = 0;
        int FREEMARK = 1;

        Map<Object, Object> MSG = MapUtil.builder()
                .put(NULL, "空")
                .put(FREEMARK, "freemark模板")
                .build()
                ;
    }

    /**
     * 语言解析器类型
     */
    interface LangConverterType {
        int NULL = 0;
        int JAVA = 1;

        Map<Object, Object> MSG = MapUtil.builder()
                .put(NULL, "空")
                .put(JAVA, "java")
                .build()
                ;
    }
}
