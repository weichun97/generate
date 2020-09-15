package com.github.weichun97.generate.api.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

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
            configuration.setTemplateLoader(new ClassTemplateLoader(FreemakerConfig.class,"/template/"));
            configuration.setNumberFormat("#");
            configuration.setClassicCompatible(true);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setLocale(Locale.CHINA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return configuration;
    }
}
