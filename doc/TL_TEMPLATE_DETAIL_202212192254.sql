INSERT INTO PUBLIC.TL_TEMPLATE_DETAIL (NAME,CONTENT,FILE_NAME,DIR,TEMPLATE_ID,DELETE_TIME,CREATE_TIME,UPDATE_TIME) VALUES
	 ('entity','package ${base.packageName};

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author ${custom.author}
 * @date ${base.datetime}
 */
@Data
@TableName("${table.name}")
public class ${table.nameUpperCamel} {
  
    <#list columns as column>
    /**
     * ${column.comment}
     */
    <#if column.primaryFlag == 1>
    @TableId<#if column.autoFlag == 1>(type = IdType.AUTO)</#if>
  	<#else>
    @TableField(value = "${column.name}"<#if column.name == ''create_time''>, fill = FieldFill.INSERT</#if><#if column.name == ''update_time''>, fill = FieldFill.UPDATE</#if>)
    </#if>
  	<#if column.name == ''delete_time''>
    @TableLogic(value = "null", delval = "now()")
   	</#if>
    private ${column.boxType} ${column.nameLowerCamel};
  
    </#list>
}','${table.nameUpperCamel}.java','${custom.serverPath}/entity/po',1,NULL,'2022-12-14 22:12:50.781+08','2022-12-19 21:44:37.867+08'),
	 ('controller','package ${base.packageName};

import com.itran.fgoc.common.core.api.Response;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}QueryParam;
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}SaveOrUpdateParam;
import ${custom.basePackage}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import ${custom.basePackage}.service.${table.nameUpperCamel}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.annotation.Resource;


/**
 * @author ${custom.author}
 * @date ${base.datetime}
 */
@RestController
@RequestMapping("${table.nameLowerCamel}")
@Api(value = "${table.nameUpperCamel}Controller", tags = "${table.comment}")
public class ${table.nameUpperCamel}Controller {

    @Resource
    private ${table.nameUpperCamel}Service service;

	@ApiOperation("${table.comment}分页")
    @GetMapping("query")
    public Response<FgocPage<${table.nameUpperCamel}QueryVO>> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam) {
        return Response.success(service.query(pageParam, ${table.nameLowerCamel}QueryParam));
    }

    @ApiOperation("保存${table.comment}")
    @PostMapping("save")
    public Response save(@Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        service.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新${table.comment}")
    @PutMapping("update/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        service.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除${table.comment}")
    @DeleteMapping("remove/{id}")
    public Response remove(@PathVariable Long id){
        service.remove(id);
        return Response.success();
    }
}
','${table.nameUpperCamel}Controller.java','${custom.serverPath}/controller',1,NULL,'2022-12-16 23:40:10.734+08','2022-12-19 22:24:50.081+08'),
	 ('queryParam','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}QueryParam")
public class ${table.nameUpperCamel}QueryParam {

   	<#list columns as column>
  	<#if column.primaryFlag == 0 && column.name != ''create_time'' && column.name != ''update_time'' && column.name != ''delete_time''>
  	@ApiModelProperty(value = "${column.comment}", example = "")
    private ${column.boxType} ${column.nameLowerCamel};
  
  	</#if>
    </#list>
}
','${table.nameUpperCamel}QueryParam.java','${custom.serverPath}/entity/param/${table.nameLower}',1,NULL,'2022-12-16 23:59:00.808+08','2022-12-19 22:06:01.89+08'),
	 ('queryVO','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}QueryVO")
public class ${table.nameUpperCamel}QueryVO {

   	<#list columns as column>
  	<#if column.name != ''create_time'' && column.name != ''update_time'' && column.name != ''delete_time''>
  	@ApiModelProperty(value = "${column.comment}", example = "")
    private ${column.boxType} ${column.nameLowerCamel};
  
  	</#if>
    </#list>
}
','${table.nameUpperCamel}QueryVO.java','${custom.serverPath}/entity/vo/${table.nameLower}',1,NULL,'2022-12-16 23:59:30.336+08','2022-12-19 22:08:47.037+08'),
	 ('service','package ${base.packageName};

import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import com.baomidou.mybatisplus.extension.service.IService;
import ${custom.basePackage}.entity.po.${table.nameUpperCamel};
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}QueryParam;
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}SaveOrUpdateParam;
import ${custom.basePackage}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;

/**
 * @author ${custom.author}
 * @date ${base.datetime}
 */
public interface ${table.nameUpperCamel}Service extends IService<${table.nameUpperCamel}> {

    /**
     * ${table.comment}分页
     * @return
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam);

    /**
     * 保存${table.comment}
     * @param ${table.nameLowerCamel}SaveOrUpdateParam
     */
    void save(${table.nameUpperCamel}SaveOrUpdateParam ${table.nameLowerCamel}SaveOrUpdateParam);

    /**
     * 删除${table.comment}
     * @param id
     */
    void remove(Long id);

    /**
     * 更新${table.comment}
     * @param id
     * @param ${table.nameLowerCamel}SaveOrUpdateParam
     */
    void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam ${table.nameLowerCamel}SaveOrUpdateParam);

}
','${table.nameUpperCamel}Service.java','${custom.serverPath}/service',1,NULL,'2022-12-19 22:15:44.072+08','2022-12-19 22:29:40.739+08'),
	 ('service','package ${base.packageName};

import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import com.baomidou.mybatisplus.extension.service.IService;
import ${custom.basePackage}.entity.po.${table.nameUpperCamel};
import ${custom.basePackage}.entity.param.${table.nameLower}.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ${custom.author}
 * @date ${base.datetime}
 */
public interface ${table.nameUpperCamel}Service extends IService<${table.nameUpperCamel}> {

    /**
     * ${table.comment}分页
     * @return
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(FgocPage pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam);

    /**
     * 保存${table.comment}
     * @param saveOrUpdateParam
     */
    void save(SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除${table.comment}
     * @param id
     */
    void remove(Long id);

    /**
     * 更新${table.comment}
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, SaveOrUpdateParam saveOrUpdateParam);

}
','${table.nameUpperCamel}Service.java','${custom.serverPath}/service',1,'2022-12-19 22:17:47.033+08','2022-12-19 22:16:22.257+08',NULL),
	 ('service','package ${base.packageName};

import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import com.baomidou.mybatisplus.extension.service.IService;
import ${custom.basePackage}.entity.po.${table.nameUpperCamel};
import ${custom.basePackage}.entity.param.${table.nameLower}.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ${custom.author}
 * @date ${base.datetime}
 */
public interface ${table.nameUpperCamel}Service extends IService<${table.nameUpperCamel}> {

    /**
     * ${table.comment}分页
     * @return
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(FgocPage pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam);

    /**
     * 保存${table.comment}
     * @param saveOrUpdateParam
     */
    void save(SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除${table.comment}
     * @param id
     */
    void remove(Long id);

    /**
     * 更新${table.comment}
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, SaveOrUpdateParam saveOrUpdateParam);

}
','${table.nameUpperCamel}Service.java','${custom.serverPath}/service',1,'2022-12-19 22:17:44.705+08','2022-12-19 22:17:12.394+08',NULL),
	 ('saveOrUpdateParam','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}SaveOrUpdateParam")
public class ${table.nameUpperCamel}SaveOrUpdateParam {

   	<#list columns as column>
  	<#if column.primaryFlag == 0 && column.name != ''create_time'' && column.name != ''update_time'' && column.name != ''delete_time''>
  	@ApiModelProperty(value = "${column.comment}", example = "")
    private ${column.boxType} ${column.nameLowerCamel};
  
  	</#if>
    </#list>
}
','${table.nameUpperCamel}SaveOrUpdateParam.java','${custom.serverPath}/entity/param/${table.nameLower}',1,'2022-12-19 22:21:25.243+08','2022-12-19 22:20:10.026+08',NULL),
	 ('saveOrUpdateParam','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}SaveOrUpdateParam")
public class ${table.nameUpperCamel}SaveOrUpdateParam {

   	<#list columns as column>
  	<#if column.primaryFlag == 0 && column.name != ''create_time'' && column.name != ''update_time'' && column.name != ''delete_time''>
  	@ApiModelProperty(value = "${column.comment}", example = "")
    private ${column.boxType} ${column.nameLowerCamel};
  
  	</#if>
    </#list>
}
','${table.nameUpperCamel}SaveOrUpdateParam.java','${custom.serverPath}/entity/param/${table.nameLower}',1,NULL,'2022-12-19 22:21:12.016+08','2022-12-19 22:23:02.538+08'),
	 ('serviceImpl','package com.github.weichun97.generate.api.service.impl;

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
','${table.nameUpperCamel}ServiceImpl.java','${custom.serverPath}/service/impl',1,'2022-12-19 22:42:24.737+08','2022-12-19 22:31:48.107+08',NULL);
INSERT INTO PUBLIC.TL_TEMPLATE_DETAIL (NAME,CONTENT,FILE_NAME,DIR,TEMPLATE_ID,DELETE_TIME,CREATE_TIME,UPDATE_TIME) VALUES
	 ('serviceImpl','package ${base.packageName};

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${custom.basePackage}.entity.dao.${table.nameUpperCamel}Dao;
import ${custom.basePackage}.entity.po.${table.nameUpperCamel};
import ${custom.basePackage}.entity.mapper.${table.nameUpperCamel}Mapper;
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}SaveOrUpdateParam
import ${custom.basePackage}.entity.param.${table.nameLower}.${table.nameUpperCamel}QueryParam;
import ${custom.basePackage}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import ${custom.basePackage}.service.${table.nameUpperCamel}Service;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.api.SelectVO;
import com.github.weichun97.generate.common.exception.ApiException;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class ${table.nameUpperCamel}ServiceImpl extends ServiceImpl<${table.nameUpperCamel}Dao, ${table.nameUpperCamel}> implements ${table.nameUpperCamel}Service {

    @Resource
    private ${table.nameUpperCamel}Service service;
    @Resource
    private ${table.nameUpperCamel}Mapper mapper;

    @Override
    public FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam) {
        return baseMapper.query(FgocPage.getPage(pageParam), ${table.nameLowerCamel}QueryParam);
    }

    @Override
    public void save(${table.nameUpperCamel}SaveOrUpdateParam ${table.nameLowerCamel}SaveOrUpdateParam) {
        save(mapper.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam ${table.nameLowerCamel}SaveOrUpdateParam) {
        update(mapper.saveOrUpdateParamToPo(${table.nameLowerCamel}SaveOrUpdateParam),
                new LambdaQueryWrapper<${table.nameUpperCamel}Entity>().eq(${table.nameUpperCamel}Entity::getId, id));
    }

    @Override
    public void remove(Long id) {
        removeById(id);
    }
}
','${table.nameUpperCamel}ServiceImpl.java','${custom.serverPath}/service/impl',1,NULL,'2022-12-19 22:40:24.161+08','2022-12-19 22:43:39.84+08');
