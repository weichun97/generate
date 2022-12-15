package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;

import java.util.List;

public interface TemplateDetailService extends IService<TemplateDetailEntity> {
    List<ListDetailVO> listDetail(ListDetailParam listDetailParam);
}
