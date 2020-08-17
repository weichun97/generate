package com.chun.generate.autoconfigure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chun
 * @date 2020/8/15 18:33
 */
@Configuration
@ComponentScan(
        basePackages = {"com.chun.generate.*"}
)
@MapperScan(basePackages = "com.chun.generate.api.pojo.dao")
public class GenerateAutoConfigure {
}
