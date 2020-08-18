package com.github.weichun97.generate.api.service;

import com.github.weichun97.generate.api.pojo.vo.generate.GenerateReqVO;
import com.github.weichun97.generate.api.pojo.vo.generate.ListResVO;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:57
 */
public interface GenerateService {

    /**
     * 表列表
     * @return
     */
    List<ListResVO> listQuery();

    /**
     * 代码生成
     * @param generateReqVO
     */
    void generate(GenerateReqVO generateReqVO);

    /**
     * 可生成文件类型
     * @return
     */
    List<String> types();
}
