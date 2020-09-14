package com.github.weichun97.generate.api.generate;

import com.github.weichun97.generate.api.config.GenerateProperties;
import com.github.weichun97.generate.api.pojo.dto.generate.TableInfoDTO;
import org.springframework.beans.factory.InitializingBean;

/**
 * The interface Generate.
 *
 * @author chun
 * @date 2020/8/13 11:35
 */
public interface Generate extends InitializingBean {

    /**
     * 生成
     *
     * @param tableInfo the table info
     * @param generateTemplate      the template
     */
    void generate(TableInfoDTO tableInfo, GenerateProperties.Template generateTemplate, String module);

    /**
     * 文件目录
     *
     * @param tableNameCamelCase the tableNameCamelCase
     * @param generateTemplate the generateTemplate
     * @return dir path
     */
    String getDirPath(String tableNameCamelCase, GenerateProperties.Template generateTemplate, String module);
}
