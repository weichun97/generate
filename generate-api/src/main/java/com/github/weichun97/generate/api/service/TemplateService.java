package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.pojo.vo.template.TemplateQueryVO;
import com.github.weichun97.generate.common.api.SelectVO;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import com.github.weichun97.generate.common.mybatis.GeneratePageParam;

import java.util.List;

public interface TemplateService extends IService<TemplateEntity> {

    /**
     * 获取模板详情列表
     * @param id
     * @return
     */
    GeneratePage<ListDetailVO> listDetail(GeneratePageParam pageParam, ListDetailParam listDetailParam);

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

    /**
     * 分页

     * @param pageParam
     * @param templateQueryParam
     * @return
     */
    GeneratePage<TemplateQueryVO> query(GeneratePageParam pageParam, TemplateQueryParam templateQueryParam);

    /**
     * 保存模板
     * @param saveOrUpdateParam
     */
    void save(SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 更新模板
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除模板
     * @param id
     */
    void remove(Long id);

    /**
     * 下拉
     * @return
     */
    List<SelectVO> select();
}
