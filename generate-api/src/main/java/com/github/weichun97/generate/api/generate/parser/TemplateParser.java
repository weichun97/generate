package com.github.weichun97.generate.api.generate.parser;

import com.github.weichun97.generate.api.generate.GenerateContext;
import com.github.weichun97.generate.api.generate.selector.SqlSelectorFactory;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

public interface TemplateParser extends InitializingBean {

    /**
     * 类型
     * @return
     */
    int getType();

    /**
     * 模板解析
     * @param content 数据
     * @param templateStr 模板字符串
     * @return
     */
    String parse(GenerateContext content, String templateStr) throws IOException, TemplateException;

    @Override
    default void afterPropertiesSet() throws Exception{
        TemplateParserFactory.register(getType(), this);
    }
}
