package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.TemplateDao;
import com.github.weichun97.generate.api.pojo.entity.TemplateDetailEntity;
import com.github.weichun97.generate.api.pojo.entity.TemplateEntity;
import com.github.weichun97.generate.api.pojo.mapper.TemplateDetailMapper;
import com.github.weichun97.generate.api.pojo.mapper.TemplateMapper;
import com.github.weichun97.generate.api.pojo.param.template.*;
import com.github.weichun97.generate.api.pojo.vo.template.CustomFieldVO;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.pojo.vo.template.TemplateQueryVO;
import com.github.weichun97.generate.api.service.TemplateDetailService;
import com.github.weichun97.generate.api.service.TemplateService;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.api.SelectVO;
import com.github.weichun97.generate.common.exception.ApiException;
import com.github.weichun97.generate.common.exception.BizAssert;
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
    public List<ListDetailVO> listDetail(ListDetailParam listDetailParam) {
        List<ListDetailVO> listDetailVOS = templateDetailService.listDetail(listDetailParam);
        return CollUtil.isEmpty(listDetailVOS) ? Collections.emptyList() : listDetailVOS;
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

    @Override
    public List<SelectVO> select() {
        List<TemplateEntity> templateEntities = list(new LambdaQueryWrapper<TemplateEntity>()
                .select(TemplateEntity::getId, TemplateEntity::getName)
        );
        return CollUtil.isEmpty(templateEntities) ? Collections.emptyList() : mapper.poToSelectVo(templateEntities);
    }

    @Override
    public List<CustomFieldVO> customFields(Long id) {
        TemplateEntity templateEntity = getById(id);
        BizAssert.assertNotNull(templateEntity, ResultCode.CODE_10007);
        String customField = templateEntity.getCustomField();
        return StrUtil.isBlank(customField) ? Collections.emptyList() : JSONUtil.toList(customField, CustomFieldVO.class);
    }

    @Override
    public void updateCustomFields(Long id, UpdateCustomFieldsParam updateCustomFieldsParam) {
        if(StrUtil.isNotBlank(updateCustomFieldsParam.getCustomField())){
            try {
                JSONUtil.toList(updateCustomFieldsParam.getCustomField(), CustomFieldVO.class);
            } catch (Exception e) {
                throw new ApiException(ResultCode.CODE_10008);
            }
        }
        update(TemplateEntity.builder()
                .customField(updateCustomFieldsParam.getCustomField())
                .build(), new LambdaQueryWrapper<TemplateEntity>()
                .eq(TemplateEntity::getId, id));
    }
}
