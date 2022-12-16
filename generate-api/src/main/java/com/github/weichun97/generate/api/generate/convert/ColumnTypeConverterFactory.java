package com.github.weichun97.generate.api.generate.convert;

import java.util.HashMap;
import java.util.Map;

public class ColumnTypeConverterFactory {

    private static final int NULL = 0;
    private static final int JAVA = 1;

    private static final Map<Integer, ColumnTypeConverter> CONTEXT = new HashMap<>();
    static {
        CONTEXT.put(NULL, new NullColumnTypeConverterImpl());
        CONTEXT.put(JAVA, new JavaColumnTypeConverterImpl());
    }

    private static ColumnTypeConverter get(int languageFlag){
        return CONTEXT.getOrDefault(languageFlag, CONTEXT.get(NULL));
    }
}
