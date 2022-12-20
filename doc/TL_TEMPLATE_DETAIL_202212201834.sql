INSERT INTO PUBLIC.TL_TEMPLATE_DETAIL (NAME,CONTENT,FILE_NAME,DIR,TEMPLATE_ID,DELETE_TIME,CREATE_TIME,UPDATE_TIME) VALUES
	 ('po','package ${base.packageName};


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("${table.name}")
@NoArgsConstructor
@AllArgsConstructor
public class ${table.nameUpperCamel}Entity {
  
  	<#list columns as column>
    /**
   	 * ${column.comment}
   	 */
    <#if column.primaryFlag == 1>
    @TableId<#if column.autoFlag == 1>(type = IdType.AUTO)</#if>
  	<#else>
    @TableField(value = "${column.name}"<#if column.name == "create_time">, fill = FieldFill.INSERT</#if><#if column.name == "update_time">, fill = FieldFill.UPDATE</#if>) 
  	</#if>
  	<#if column.name == "delete_time">
    @TableLogic(value = "null", delval = "now()")
  	</#if>
  	private ${column.boxType} ${column.nameLowerCamel};
  
  	</#list>
}
','${table.nameUpperCamel}Entity.java','${base.baseDir}/entity/po',1,NULL,'2022-12-14 15:31:03.897+08','2022-12-20 16:48:58.413+08'),
	 ('1','1','1',NULL,33,'2022-12-20 16:24:17.916+08','2022-12-15 18:21:14.121+08',NULL),
	 ('11','<#list columns as column >
  ${column.name}
</#list>','11','11',33,'2022-12-20 16:24:19.974+08','2022-12-19 11:10:54.668+08','2022-12-19 11:15:19.774+08'),
	 ('saveOrUpdateParam','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}SaveOrUpdateParam")
public class ${table.nameUpperCamel}SaveOrUpdateParam {
  
  	<#list columns as column>
    <#if column.name != "id" && column.name != "update_time" && column.name != "delete_time">
    @ApiModelProperty(value = "${column.comment}", example = "")
  	private ${column.boxType} ${column.nameLowerCamel};
  
    </#if>
  	</#list>
}
','${table.nameUpperCamel}SaveOrUpdateParam.java','${base.baseDir}/entity/param/${table.nameLower}',1,NULL,'2022-12-20 16:23:50.424+08','2022-12-20 18:23:32.302+08'),
	 ('queryParam','package ${base.packageName};


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("${table.name}")
public class ${table.nameUpperCamel}QueryParam {
  
  	<#list columns as column>
    <#if column.name != "id" && column.name != "create_time" && column.name != "update_time" && column.name != "delete_time">
    @ApiModelProperty(value = "${column.comment}", example = "")
  	private ${column.boxType} ${column.nameLowerCamel};
  
    </#if>
  	</#list>
}
','${table.nameUpperCamel}QueryParam.java','${base.baseDir}/entity/param/${table.nameLower}',1,'2022-12-20 16:31:52.627+08','2022-12-20 16:30:18.146+08',NULL),
	 ('queryParam','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}QueryParam")
public class ${table.nameUpperCamel}QueryParam {
  
  	<#list columns as column>
    <#if column.name != "id" && column.name != "create_time" && column.name != "update_time" && column.name != "delete_time">
    @ApiModelProperty(value = "${column.comment}", example = "")
  	private ${column.boxType} ${column.nameLowerCamel};
  
    </#if>
  	</#list>
}
','${table.nameUpperCamel}QueryParam.java','${base.baseDir}/entity/param/${table.nameLower}',1,NULL,'2022-12-20 16:31:32.205+08',NULL),
	 ('queryVO','package ${base.packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("${base.packageName}.${table.nameUpperCamel}QueryVO")
public class ${table.nameUpperCamel}QueryVO {
  
  	<#list columns as column>
    <#if column.name != "update_time" && column.name != "delete_time">
    @ApiModelProperty(value = "${column.comment}", example = "")
  	private ${column.boxType} ${column.nameLowerCamel};
  
    </#if>
  	</#list>
}
','${table.nameUpperCamel}QueryVO.java','${base.baseDir}/entity/vo/${table.nameLower}',1,NULL,'2022-12-20 16:36:55.381+08',NULL),
	 ('dao','package ${base.packageName};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${base.basePackageName}.pojo.entity.${table.nameUpperCamel}Entity;
import ${base.basePackageName}.pojo.param.template.${table.nameUpperCamel}QueryParam;
import ${base.basePackageName}.pojo.vo.template.${table.nameUpperCamel}QueryVO;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ${table.nameUpperCamel}Dao extends BaseMapper<${table.nameUpperCamel}Entity> {

    /**
     * 分页
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(FgocPage<${table.nameUpperCamel}QueryVO> fgocPage, @Param("queryParam") ${table.nameUpperCamel}QueryParam queryParam);
}','${table.nameUpperCamel}Dao.java','${base.baseDir}/entity/dao/${table.nameLower}',1,'2022-12-20 16:46:40.798+08','2022-12-20 16:45:49.399+08',NULL),
	 ('dao','package ${base.packageName};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;
import ${base.basePackageName}.entity.param.${table.nameLower}.${table.nameUpperCamel}QueryParam;
import ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ${table.nameUpperCamel}Dao extends BaseMapper<${table.nameUpperCamel}Entity> {

    /**
     * 分页
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(FgocPage<${table.nameUpperCamel}QueryVO> fgocPage, @Param("queryParam") ${table.nameUpperCamel}QueryParam queryParam);
}','${table.nameUpperCamel}Dao.java','${base.baseDir}/entity/dao',1,NULL,'2022-12-20 16:46:25.967+08','2022-12-20 16:47:48.891+08'),
	 ('mapper','package ${base.packageName};

import ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;
import ${base.basePackageName}.entity.param.${table.nameLower}.${table.nameUpperCamel}SaveOrUpdateParam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ${table.nameUpperCamel}Mapper {

    ${table.nameUpperCamel}Entity saveOrUpdateParamToPo(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);
}
','${table.nameUpperCamel}Mapper.java','${base.baseDir}/entity/mapper',1,NULL,'2022-12-20 16:52:03.745+08','2022-12-20 16:53:34.642+08');
INSERT INTO PUBLIC.TL_TEMPLATE_DETAIL (NAME,CONTENT,FILE_NAME,DIR,TEMPLATE_ID,DELETE_TIME,CREATE_TIME,UPDATE_TIME) VALUES
	 ('service','package ${base.packageName};

import com.baomidou.mybatisplus.extension.service.IService;
import ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;
import ${base.basePackageName}.entity.param.${table.nameLower}.*;
import ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;

public interface ${table.nameUpperCamel}Service extends IService<${table.nameUpperCamel}Entity> {

    /**
     * ${table.comment}分页

     * @param pageParam
     * @param queryParam
     * @return
     */
    FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam queryParam);

    /**
     * 保存${table.comment}
     * @param saveOrUpdateParam
     */
    void save(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 更新${table.comment}
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除${table.comment}
     * @param id
     */
    void remove(Long id);
}
','${table.nameUpperCamel}Service.java','${base.baseDir}/service',1,NULL,'2022-12-20 16:57:42.852+08','2022-12-20 16:58:27.597+08'),
	 ('serviceImpl','package ${base.packageName};

import ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;
import ${base.basePackageName}.entity.mapper.${table.nameUpperCamel}Mapper;
import ${base.basePackageName}.entity.dao.${table.nameUpperCamel}Dao;
import ${base.basePackageName}.entity.param.${table.nameLower}.*;
import ${base.basePackageName}.service.${table.nameUpperCamel}Service;
import ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;

@Service
public class ${table.nameUpperCamel}ServiceImpl extends ServiceImpl<${table.nameUpperCamel}Dao, ${table.nameUpperCamel}Entity> implements ${table.nameUpperCamel}Service {

    @Resource
    private ${table.nameUpperCamel}Mapper mapper;

    @Override
    public FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam queryParam) {
        return baseMapper.query(FgocPage.getPage(pageParam), queryParam);
    }

    @Override
    public void save(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam) {
        save(mapper.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam) {
        update(mapper.saveOrUpdateParamToPo(saveOrUpdateParam),
                new LambdaQueryWrapper<${table.nameUpperCamel}Entity>().eq(${table.nameUpperCamel}Entity::getId, id));
    }

    @Override
    public void remove(Long id) {
        removeById(id);
    }
}
','${table.nameUpperCamel}ServiceImpl.java','${base.baseDir}/service/impl',1,NULL,'2022-12-20 17:04:47.753+08','2022-12-20 17:08:07.331+08'),
	 ('controller','package ${base.packageName};

import ${base.basePackageName}.entity.param.${table.nameLower}.*;
import ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import ${base.basePackageName}.service.${table.nameUpperCamel}Service;
import com.github.weichun97.generate.common.api.Response;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(value = "${table.nameUpperCamel}Controller", tags = "${table.comment}")
@RequestMapping("${table.nameLowerCamel}")
@RestController
public class ${table.nameUpperCamel}Controller {

    @Resource
    private ${table.nameUpperCamel}Service ${table.nameLowerCamel}Service;

    @ApiOperation("${table.comment}列表分页")
    @GetMapping("query")
    public Response<GeneratePage<${table.nameUpperCamel}QueryVO>> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam) {
        return Response.success(${table.nameLowerCamel}Service.query(pageParam, ${table.nameLowerCamel}QueryParam));
    }

    @ApiOperation("保存${table.comment}")
    @PostMapping("save")
    public Response save(@Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        ${table.nameLowerCamel}Service.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新${table.comment}")
    @PutMapping("update/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        ${table.nameLowerCamel}Service.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除${table.comment}")
    @DeleteMapping("remove/{id}")
    public Response remove(@PathVariable Long id){
        ${table.nameLowerCamel}Service.remove(id);
        return Response.success();
    }
}','${table.nameUpperCamel}Controller.java','${base.baseDir}/controller',1,'2022-12-20 17:16:47.043+08','2022-12-20 17:14:46.322+08',NULL),
	 ('controller','package ${base.packageName};

import ${base.basePackageName}.entity.param.${table.nameLower}.*;
import ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;
import ${base.basePackageName}.service.${table.nameUpperCamel}Service;
import com.itran.fgoc.common.core.api.Response;
import com.itran.fgoc.common.mybatisplus.FgocPage;
import com.itran.fgoc.common.mybatisplus.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(value = "${table.nameUpperCamel}Controller", tags = "${table.comment}")
@RequestMapping("${table.nameLowerCamel}")
@RestController
public class ${table.nameUpperCamel}Controller {

    @Resource
    private ${table.nameUpperCamel}Service ${table.nameLowerCamel}Service;

    @ApiOperation("${table.comment}列表分页")
    @GetMapping("query")
    public Response<FgocPage<${table.nameUpperCamel}QueryVO>> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam) {
        return Response.success(${table.nameLowerCamel}Service.query(pageParam, ${table.nameLowerCamel}QueryParam));
    }

    @ApiOperation("保存${table.comment}")
    @PostMapping("save")
    public Response save(@Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        ${table.nameLowerCamel}Service.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新${table.comment}")
    @PutMapping("update/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){
        ${table.nameLowerCamel}Service.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除${table.comment}")
    @DeleteMapping("remove/{id}")
    public Response remove(@PathVariable Long id){
        ${table.nameLowerCamel}Service.remove(id);
        return Response.success();
    }
}','${table.nameUpperCamel}Controller.java','${base.baseDir}/controller',1,NULL,'2022-12-20 17:16:29.953+08',NULL),
	 ('daoXml','<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${base.basePackageName}.entity.dao.${table.nameUpperCamel}Dao">

    <select id="query" resultType="${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO">
        select t1.* from ${table.name} t1
        <where>
            t1.delete_time is null
        </where>
        order by id desc
    </select>
</mapper>','${table.nameUpperCamel}Dao.xml','${base.baseDir}/entity/dao',1,NULL,'2022-12-20 17:22:27.599+08','2022-12-20 17:56:10.565+08');
