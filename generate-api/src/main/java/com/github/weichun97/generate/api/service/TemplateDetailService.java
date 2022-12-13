package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import org.apache.ibatis.annotations.Param;

public interface TemplateDetailService extends IService<TemplateDetailEntity> {
    GeneratePage<ListDetailVO> listDetail(GeneratePage page, ListDetailParam listDetailParam);
}
