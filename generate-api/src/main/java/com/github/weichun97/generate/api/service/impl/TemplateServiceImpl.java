package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.mapper.TemplateDetailMapper;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.service.TemplateDetailService;
import com.github.weichun97.generate.api.service.TemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateDetailService templateDetailService;
    @Resource
    private TemplateDetailMapper templateDetailMapper;

    @Override
    public List<ListDetailVO> listDetail(Long id) {
        List<TemplateDetailEntity> templateDetailEntities = templateDetailService.list(new LambdaQueryWrapper<TemplateDetailEntity>()
                .eq(TemplateDetailEntity::getTemplateId, id)
        );
        return CollUtil.isEmpty(templateDetailEntities) ? Collections.emptyList() : templateDetailMapper.poToListDetailByIdVo(templateDetailEntities);
    }

    @Override
    public void removeDetail(Long id) {
        templateDetailService.removeById(id);
    }

    @Override
    public void updateDetail(Long id, SaveOrUpdateDetailParam saveOrUpdateDetailParam) {
        templateDetailService.update(templateDetailMapper.saveOrUpdateDetailParamToPo(saveOrUpdateDetailParam),
                new LambdaQueryWrapper<TemplateDetailEntity>().eq(TemplateDetailEntity::getId, id));
    }

    @Override
    public void saveDetail(SaveOrUpdateDetailParam saveOrUpdateDetailParam) {
        TemplateDetailEntity templateDetailEntity = templateDetailMapper.saveOrUpdateDetailParamToPo(saveOrUpdateDetailParam);
        templateDetailService.save(templateDetailEntity);
    }
}
