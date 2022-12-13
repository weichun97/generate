package com.github.weichun97.generate.api.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface TemplateDetailDao extends BaseMapper<TemplateDetailEntity> {
    GeneratePage<ListDetailVO> listDetail(@Param("page") GeneratePage page, @Param("listDetailParam") ListDetailParam listDetailParam);
}
