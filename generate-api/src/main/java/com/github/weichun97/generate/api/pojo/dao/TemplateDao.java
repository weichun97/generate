package com.github.weichun97.generate.api.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam;
import com.github.weichun97.generate.api.pojo.vo.template.TemplateQueryVO;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import com.github.weichun97.generate.common.mybatis.GeneratePageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface TemplateDao extends BaseMapper<TemplateEntity> {

    /**
     * 分页
     */
    GeneratePage<TemplateQueryVO> query(@Param("generatePage") GeneratePage<TemplateQueryVO> generatePage, @Param("templateQueryParam") TemplateQueryParam templateQueryParam);
}
