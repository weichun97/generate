package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.TemplateDao;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.mapper.TemplateDetailMapper;
import com.github.weichun97.generate.api.pojo.mapper.TemplateMapper;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.pojo.vo.template.TemplateQueryVO;
import com.github.weichun97.generate.api.service.TemplateDetailService;
import com.github.weichun97.generate.api.service.TemplateService;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import com.github.weichun97.generate.common.mybatis.GeneratePageParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateDao, TemplateEntity> implements TemplateService {

    @Resource
    private TemplateDetailService templateDetailService;
    @Resource
    private TemplateMapper mapper;
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

    @Override
    public GeneratePage<TemplateQueryVO> query(GeneratePageParam pageParam, TemplateQueryParam templateQueryParam) {
        return baseMapper.query(GeneratePage.getPage(pageParam), templateQueryParam);
    }

    @Override
    public void save(SaveOrUpdateParam saveOrUpdateParam) {
        save(mapper.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void update(Long id, SaveOrUpdateParam saveOrUpdateParam) {
        update(mapper.saveOrUpdateParamToPo(saveOrUpdateParam),
                new LambdaQueryWrapper<TemplateEntity>().eq(TemplateEntity::getId, id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        removeById(id);
        templateDetailService.remove(new LambdaQueryWrapper<TemplateDetailEntity>()
                .eq(TemplateDetailEntity::getTemplateId, id)
        );
    }
}
