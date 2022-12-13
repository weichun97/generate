package com.github.weichun97.generate.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.TemplateDetailDao;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.service.TemplateDetailService;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import org.springframework.stereotype.Service;

@Service
public class TemplateDetailServiceImpl extends ServiceImpl<TemplateDetailDao, TemplateDetailEntity> implements TemplateDetailService {

    @Override
    public GeneratePage<ListDetailVO> listDetail(GeneratePage page, ListDetailParam listDetailParam) {
        return baseMapper.listDetail(page, listDetailParam);
    }
}
