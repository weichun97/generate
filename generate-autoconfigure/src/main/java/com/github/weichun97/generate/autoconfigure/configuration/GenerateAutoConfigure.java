package com.github.weichun97.generate.autoconfigure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chun
 * @date 2020/8/15 18:33
 */
@Configuration
@ComponentScan(
        basePackages = {"com.github.weichun97.generate.*"}
)
@MapperScan(basePackages = "com.github.weichun97.generate.api.pojo.dao")
public class GenerateAutoConfigure {
}
