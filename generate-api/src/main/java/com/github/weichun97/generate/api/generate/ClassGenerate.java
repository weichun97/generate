package com.github.weichun97.generate.api.generate;

import cn.hutool.core.util.StrUtil;
import com.github.weichun97.generate.api.config.GenerateProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author chun
 * @date 2020/8/13 11:35
 */
@Component
public class ClassGenerate extends BaseGenerate {

    @Override
    public void afterPropertiesSet() {
        GenarateFactory.regist(GenarateFactory.CLASS_GENERATE_KEY, this);
    }

    @Override
    public String getDirPath(String tableNameCamelCase, GenerateProperties.Template generateTemplate, String module) {
        String path = "src" + File.separator + "main" + File.separator + "java" + File.separator +
                this.getPackageName().replace(".", File.separator);
        if(StrUtil.isNotBlank(module)){
            path += File.separator + module.replace(".", "/");
        }
        path += File.separator + generateTemplate.getDir();
        if(generateTemplate.getNeedTablePackage() != null && generateTemplate.getNeedTablePackage()){
            path += File.separator + tableNameCamelCase.toLowerCase();
        }
        return path;
    }
}
