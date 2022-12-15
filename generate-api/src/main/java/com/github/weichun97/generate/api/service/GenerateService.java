package com.github.weichun97.generate.api.service;

import com.github.weichun97.generate.api.pojo.param.generate.GenerateParam;
import com.github.weichun97.generate.api.pojo.vo.generate.GenerateVO;
import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:57
 */
public interface GenerateService {

    /**
     * 代码生成
     * @param generateParam
     */
    List<GenerateVO> generate(GenerateParam generateParam);

    /**
     * 可生成文件类型
     * @return
     */
    List<String> types();

    /**
     * 表列表
     * @param datasourceId
     * @return
     */
    List<TablesVO> tables(Long datasourceId);
}
