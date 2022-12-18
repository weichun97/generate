package com.github.weichun97.generate.api.generate.convert;

import com.github.weichun97.generate.api.var.GenerateVar;
import org.springframework.beans.factory.InitializingBean;

/**
 * 将数据库类型转换成各语言对应的类型
 */
public interface ColumnTypeConverter extends InitializingBean {

    /**
     * 语言类型
     * @see GenerateVar.LangConverterType
     *
     * @return
     */
    int getType();

    /**
     * 将数据库类型转成基本类型
     * @param type 数据库类型
     * @return 基本类型
     */
    String convertType(String type);

    /**
     * 将数据库类型转成装箱类型
     * @param type 数据库类型
     * @return 装箱类型
     */
    String convertTypeBox(String type);

    @Override
    default void afterPropertiesSet() throws Exception{
        ColumnTypeConverterFactory.register(getType(), this);
    }
}
