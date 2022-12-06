package com.github.weichun97.generate.api.service;

import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;

import java.util.List;

public interface TemplateService {

    /**
     * 获取模板详情列表
     * @param id
     * @return
     */
    List<ListDetailVO> listDetail(Long id);

    /**
     * 删除模板详情
     * @param id
     */
    void removeDetail(Long id);

    /**
     * 更新模板详情
     * @param id
     * @param saveOrUpdateDetailParam
     */
    void updateDetail(Long id, SaveOrUpdateDetailParam saveOrUpdateDetailParam);

    /**
     * 保存模板详情
     * @param saveOrUpdateDetailParam
     */
    void saveDetail(SaveOrUpdateDetailParam saveOrUpdateDetailParam);
}
