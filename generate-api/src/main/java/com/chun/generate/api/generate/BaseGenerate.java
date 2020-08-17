package com.chun.generate.api.generate;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.chun.generate.common.util.SpringUtils;
import com.chun.generate.api.config.GenerateProperties;
import com.chun.generate.api.pojo.dto.generate.TableInfoDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/13 11:35
 */
@Slf4j
@Data
public abstract class BaseGenerate implements Generate {

    @Resource
    Configuration configuration;
    @Resource
    SpringUtils springUtils;
    @Resource
    GenerateProperties generateProperties;

    @Override
    public void generate(TableInfoDTO tableInfo, String type) {
        Template template = this.getTemplate(type);
        String filePath = this.getFilePath(tableInfo.getTableNameCamelCase(), type);
        try {
            Writer writer = new FileWriter(FileUtil.file(filePath));
            Map map = MapUtil.builder()
                    .put("packageName", this.getPackageName())
                    .put("tableInfo", tableInfo)
                    .build();
            template.process(map, writer);
        } catch (TemplateException | IOException e) {
            log.error("{}创建失败", tableInfo.getTableName() + "-" + type);
            e.printStackTrace();
        }
    }

    /**
     * 获取文件生成地址
     * @param tableNameCamelCase
     * @param type
     * @return
     */
    protected String getFilePath(String tableNameCamelCase, String type){
        String filePath = this.getRootDir() + File.separator
                + this.getDirPath(type);
        if(!FileUtil.isDirectory(filePath)){
            FileUtil.mkdir(filePath);
        }
        String fileName = tableNameCamelCase + generateProperties.getTemplateMap().get(type).getSuffix();
        return filePath + File.separator + fileName;
    }

    /**
     * 获取项目包名
     * 如果配置文件有配置，则优先使用配置文件
     * @return
     */
    protected String getPackageName(){
        String packageName = generateProperties.getPackageName();
        if(StrUtil.isEmpty(packageName)){
            packageName = springUtils.getRootPackage();
        }
        return packageName;
    }

    /**
     * 获取项目根目录
     * 如果配置文件有配置，则优先使用配置文件
     * @return
     */
    @Nullable
    protected String getRootDir(){
        String rootDir = generateProperties.getRootDir();
        if(StrUtil.isEmpty(rootDir)){
            rootDir = springUtils.getRootPath();
        }
        return rootDir;
    }

    /**
     * 获取模板
     * @return
     */
    private Template getTemplate(String type){
        try {
            return configuration.getTemplate(generateProperties.getTemplateMap().get(type).getTemplateFile());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
