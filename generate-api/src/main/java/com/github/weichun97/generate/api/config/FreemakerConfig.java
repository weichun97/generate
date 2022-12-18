package com.github.weichun97.generate.api.config;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;

/**
 * @author chun
 * @date 2020/8/12 18:38
 */
@org.springframework.context.annotation.Configuration
public class FreemakerConfig {

    @Bean("chunGenerateFreemakerConfig")
    public Configuration getConfiguration() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        try {
            configuration.setTemplateLoader(new StringTemplateLoader());
            configuration.setNumberFormat("#");
            configuration.setDefaultEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return configuration;
    }
}
