package com.github.weichun97.generate.api.generate;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/13 11:35
 */
@Component
public class ClassGenerate extends BaseGenerate {

    /**
     * 可以生成的模板类型
     */
    public static final List<String> TYPE_LIST = Arrays.asList(new String[]{
            GenerateVar.ENTITY,
            GenerateVar.DAO,
            GenerateVar.SERVICE,
            GenerateVar.SERVICE_IMPL,
            GenerateVar.MAPPER
    });

    @Override
    public void afterPropertiesSet() {
        GenarateFactory.regist(GenarateFactory.CLASS_GENERATE_KEY, this);
    }

    @Override
    public String getDirPath(String type) {
        return "src" + File.separator + "main" + File.separator + "java" + File.separator +
                this.getPackageName().replace(".", File.separator) + File.separator +
                generateProperties.getTemplateMap().get(type).getDir();
    }
}
