package com.chun.generate.common.util;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/15 23:48
 */
@Slf4j
@Component
public class SpringUtils {

    @Resource
    ApplicationContext context;
    @Resource
    Environment environment;

    /**
     * 获取 spring 项目的根目录
     * @return
     */
    @Nullable
    public String getRootPath(){
        try {
            return ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 获取 spring 项目的启动类的包名
     * @return
     */
    @Nullable
    public String getRootPackage(){
        Map<String, Object> candidates = context.getBeansWithAnnotation(SpringBootApplication.class);
        return CollUtil.isNotEmpty(candidates.values()) ? candidates.values().toArray()[0].getClass().getPackage().getName() : null;
    }
}
