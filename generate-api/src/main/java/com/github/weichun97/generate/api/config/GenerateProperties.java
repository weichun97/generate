package com.github.weichun97.generate.api.config;

import com.github.weichun97.generate.api.generate.GenarateFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chun
 * @date 2020/8/16 8:21
 */
@Data
@Component
@ConfigurationProperties(prefix = "chun.generate")
public class GenerateProperties {

    /**
     * 项目根目录
     */
    private String rootDir;

    /**
     * 项目包名
     */
    private String packageName;

    /**
     * 模板信息
     */
    private Map<String, Template> templateMap;

    @PostConstruct
    public void init(){
        if(templateMap == null){
            templateMap = new HashMap<>();
            templateMap.put("entity", new Template("java/entity.ftl", "pojo/entity", "Entity.java", "class"));
            templateMap.put("dao", new Template("java/dao.ftl", "pojo/dao", "Dao.java", "class"));
            templateMap.put("daoXml", new Template("java/dao_xml.ftl", "pojo/mapper", "Dao.xml", "resource"));
            templateMap.put("service", new Template("java/service.ftl", "service", "Service.java", "class"));
            templateMap.put("serviceImpl", new Template("java/service_impl.ftl", "service/impl", "ServiceImpl.java", "class"));
            templateMap.put("mapstruct", new Template("java/mapper.ftl", "pojo/mapper", "Mapper.java", "class"));
        }
    }

    /**
     * 模板信息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Template{

        private Template(String templateFile, String dir, String suffix, String type) {
            this.templateFile = templateFile;
            this.dir = dir;
            this.suffix = suffix;
            this.type = type;
        }

        /**
         * 模板文件地址，相对于在 resources 文件夹
         */
        private String templateFile;

        /**
         * 文件夹目录
         */
        private String dir;

        /**
         * 文件后缀
         */
        private String suffix;

        /**
         * 生成器类型
         * @see GenarateFactory
         */
        private String type;

        /**
         * 是否需要包名层级
         */
        private Boolean needTablePackage;

        /**
         * 子模板
         */
        private Map<String, Template> child;
    }
}
