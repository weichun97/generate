package com.github.weichun97.generate.api.generate;

import com.github.weichun97.generate.api.pojo.dto.generate.TableInfoDTO;
import org.springframework.beans.factory.InitializingBean;

public interface Generate extends InitializingBean {

    /**
     * 生成
     */
    void generate(TableInfoDTO tableInfo, String type);

    /**
     * 文件目录
     * @param type
     * @return
     */
    String getDirPath(String type);
}