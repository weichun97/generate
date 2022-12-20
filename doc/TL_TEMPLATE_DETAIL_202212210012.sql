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
	 ('queryParam','<template>
  <div class="app-container">
    <!-- 搜索 -->
    <div class="filter-container">
      <el-input v-model="listParam.name" placeholder="测试" style="width: 200px;" clearable class="filter-item" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        查询
      </el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleResetQuery">
        重置
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
        新增
      </el-button>
    </div>

    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="序号" width="95">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <#list columns as column>
      <#if column.name != "id" && column.name != "create_time" && column.name != "update_time" && column.name != "delete_time">
      <#if column.baseType == "Date">
      <el-table-column
        align="center"
        prop="${column.nameLowerCamel}"
        label="${column.comment}"
        width="200"
      >
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.${column.nameLowerCamel} }}</span>
        </template>
      </el-table-column>
      <#else>
      <el-table-column label="${column.comment}">
        <template slot-scope="scope">
          {{ scope.row.${column.nameLowerCamel} }}
        </template>
      </el-table-column>
      </#if>
      </#if>
      </#list>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="small"
            @click="handleDetail(scope.row)"
          >详情</el-button>
          <el-button
            type="text"
            size="small"
            @click="handleCustom(scope.row)"
          >自定义</el-button>
          <el-button
            type="text"
            size="small"
            @click="handleEdit(scope.row)"
          >编辑</el-button>
          <el-button
            type="text"
            size="small"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <Pagination :total="total" :page.sync="listParam.current" :limit.sync="listParam.size" @pagination="fetchData" />

    <!-- 新增更新弹框 -->
    <el-dialog :title="saveOrUpdateFormTitile" :visible.sync="saveOrUpdateFormVisible">
      <el-form
        :ref="saveOrUpdateFormRef"
        :model="saveOrUpdateForm"
        status-icon
        :rules="saveOrUpdateFormRules"
        label-width="100px"
      >
        <el-form-item label="模板名" prop="name">
          <el-input
            v-model="saveOrUpdateForm.name"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="根目录" prop="baseDir">
          <el-input
            v-model="saveOrUpdateForm.baseDir"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            :loading="saveOrUpdateLoading"
            @click="saveOrUpdateTemplate()"
          >提交</el-button>
          <el-button @click="saveOrUpdateFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 自定义 -->
    <el-dialog :title="customFieldTableDialogTitle" :visible.sync="customFieldTableDialogVisible">
      <el-button type="primary" @click="addNewField">添加</el-button>
      <el-button type="primary" @click="editModeEnabled = true">编辑</el-button>
      <el-button type="primary" @click="saveFields">保存</el-button>
      <el-table
        :data="customFieldTableData"
        style="width: 100%"
      >
        <el-table-column
          prop="key"
          label="key"
        >
          <editable-cell
            v-model="row.key"
            slot-scope="{row}"
            :can-edit="editModeEnabled"
          >
            <span slot="content">{{ row.key }}</span>
          </editable-cell>
        </el-table-column>

        <el-table-column
          prop="value"
          label="value"
        >
          <editable-cell
            v-model="row.value"
            slot-scope="{row}"
            :can-edit="editModeEnabled"
          >
            <span slot="content">{{ row.value }}</span>
          </editable-cell>
        </el-table-column>

        <el-table-column
          v-if="editModeEnabled"
          label="操作"
          width="180"
        >
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="handleDeleteField(scope.row)"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import { query, save, update, remove } from ''@/api/${column.nameLowerCamel}''
import Pagination from ''@/components/Pagination''
import { showDeleteDialog, showSuccessDialog } from ''@/utils/common''

export default {
  components: {
    Pagination
  },
  data() {
    return {
      // 分页
      total: 0,
      listParam: {
        current: 1,
        size: 10
      },
      list: [],
      listLoading: true,
      // 新增、修改
      saveOrUpdateLoading: false,
      saveOrUpdateFormRef: ''saveOrUpdateFormRef'',
      saveOrUpdateFormTitile: ''新增'',
      saveOrUpdateFormVisible: false,
      updateId: null,
      saveOrUpdateForm: {
        name: null
      },
      saveOrUpdateFormRules: {
        name: [
          { required: true, message: ''请输入模板名'', trigger: ''blur'' },
          { min: 1, max: 20, message: ''长度在 1 到 20 个字符'', trigger: ''blur'' }
        ]
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    // 分页
    handleFilter() {
      this.fetchData()
    },
    handleResetQuery() {
      this.listParam = {
        current: 1,
        size: 10
      }
      this.fetchData()
    },
    fetchData() {
      this.listLoading = true
      query(this.listParam).then((response) => {
        this.list = response.data.records
        this.total = response.data.total
        this.listLoading = false
      })
    },
    // 详情
    handleDetail(row) {
      this.$router.push({
        name: ''Detail${column.nameUpperCamel}'',
        params: {
          id: row.id
        }
      })
    },
    // 新增、编辑
    handleEdit(row) {
      this.saveOrUpdateFormTitile = ''编辑''
      this.updateId = row.id
      this.saveOrUpdateForm = Object.assign({}, row)
      this.saveOrUpdateFormVisible = true
    },
    handleCreate() {
      this.saveOrUpdateFormTitile = ''新增''
      this.updateId = null
      this.saveOrUpdateForm = {}
      this.saveOrUpdateFormVisible = true
    },
    update${column.nameUpperCamel}() {
      this.saveOrUpdateLoading = true
      update(this.saveOrUpdateForm, this.updateId).then(() => {
        this.saveOrUpdateForm = {}
        this.saveOrUpdateFormVisible = false
        this.fetchData()
        showSuccessDialog(this)
        this.saveOrUpdateLoading = false
      }).catch(() => {
        this.saveOrUpdateLoading = false
      })
    },
    save${column.nameUpperCamel}() {
      this.saveOrUpdateLoading = true
      save(this.saveOrUpdateForm).then(() => {
        this.saveOrUpdateForm = {}
        this.saveOrUpdateFormVisible = false
        this.fetchData()
        showSuccessDialog(this)
        this.saveOrUpdateLoading = false
      }).catch(() => {
        this.saveOrUpdateLoading = false
      })
    },
    saveOrUpdate${column.nameUpperCamel}() {
      this.$refs[this.saveOrUpdateFormRef].validate((valid) => {
        if (valid) {
          this.updateId == null ? this.save${column.nameUpperCamel}() : this.update${column.nameUpperCamel}()
        }
      })
    },
    // 删除
    handleDelete(row) {
      showDeleteDialog(this, () => {
        remove(row.id).then(() => {
          this.fetchData()
          showSuccessDialog(this)
        })
      })
    }
  }
}
</script>','${table.nameUpperCamel}QueryParam.java','${base.baseDir}/entity/param/${table.nameLower}',1,NULL,'2022-12-20 16:31:32.205+08','2022-12-20 22:58:28.836+08'),
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
</mapper>','${table.nameUpperCamel}Dao.xml','${base.baseDir}/entity/dao',1,NULL,'2022-12-20 17:22:27.599+08','2022-12-20 17:56:10.565+08'),
	 ('index','<template>
    <div class="app-container">
      <!-- 搜索 -->
      <div class="filter-container">
        <el-input v-model="listParam.name" placeholder="测试" style="width: 200px;" clearable class="filter-item" />
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
          查询
        </el-button>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleResetQuery">
          重置
        </el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
          新增
        </el-button>
      </div>
  
      <!-- 表格 -->
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
      >
        <el-table-column align="center" label="序号" width="95">
          <template slot-scope="scope">
            {{ scope.$index + 1 }}
          </template>
        </el-table-column>
        <#list columns as column>
        <#if column.name != "id" && column.name != "create_time" && column.name != "update_time" && column.name != "delete_time">
        <#if column.baseType == "Date">
        <el-table-column
          align="center"
          prop="${column.nameLowerCamel}"
          label="${column.comment}"
          width="200"
        >
          <template slot-scope="scope">
            <i class="el-icon-time" />
            <span>{{ scope.row.${column.nameLowerCamel} }}</span>
          </template>
        </el-table-column>
        <#else>
        <el-table-column label="${column.comment}">
          <template slot-scope="scope">
            {{ scope.row.${column.nameLowerCamel} }}
          </template>
        </el-table-column>
        </#if>
        </#if>
        </#list>
        <el-table-column fixed="right" label="操作" width="200">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="handleEdit(scope.row)"
            >编辑</el-button>
            <el-button
              type="text"
              size="small"
              @click="handleDelete(scope.row)"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <!-- 分页 -->
      <Pagination :total="total" :page.sync="listParam.current" :limit.sync="listParam.size" @pagination="fetchData" />
  
      <!-- 新增更新弹框 -->
      <el-dialog :title="saveOrUpdateFormTitile" :visible.sync="saveOrUpdateFormVisible">
        <el-form
          :ref="saveOrUpdateFormRef"
          :model="saveOrUpdateForm"
          status-icon
          :rules="saveOrUpdateFormRules"
          label-width="100px"
        >
        <#list columns as column>
        <#if column.name != "id" && column.name != "create_time" && column.name != "update_time" && column.name != "delete_time">
          <el-form-item label="${column.comment}" prop="${column.nameLowerCamel}">
            <el-input
              v-model="saveOrUpdateForm.${column.nameLowerCamel}"
              type="text"
              autocomplete="off"
            />
          </el-form-item>
        </#if>
        </#list> 
          <el-form-item>
            <el-button
              type="primary"
              :loading="saveOrUpdateLoading"
              @click="saveOrUpdate${table.nameUpperCamel}()"
            >提交</el-button>
            <el-button @click="saveOrUpdateFormVisible = false">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { query, save, update, remove } from ''@/api/${table.nameLowerCamel}''
  import Pagination from ''@/components/Pagination''
  import { showDeleteDialog, showSuccessDialog } from ''@/utils/common''
  
  export default {
    components: {
      Pagination
    },
    data() {
      return {
        // 分页
        total: 0,
        listParam: {
          current: 1,
          size: 10
        },
        list: [],
        listLoading: true,
        // 新增、修改
        saveOrUpdateLoading: false,
        saveOrUpdateFormRef: ''saveOrUpdateFormRef'',
        saveOrUpdateFormTitile: ''新增'',
        saveOrUpdateFormVisible: false,
        updateId: null,
        saveOrUpdateForm: {
          name: null
        },
        saveOrUpdateFormRules: {
          name: [
            { required: true, message: ''请输入模板名'', trigger: ''blur'' },
            { min: 1, max: 20, message: ''长度在 1 到 20 个字符'', trigger: ''blur'' }
          ]
        }
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      // 分页
      handleFilter() {
        this.fetchData()
      },
      handleResetQuery() {
        this.listParam = {
          current: 1,
          size: 10
        }
        this.fetchData()
      },
      fetchData() {
        this.listLoading = true
        query(this.listParam).then((response) => {
          this.list = response.data.records
          this.total = response.data.total
          this.listLoading = false
        })
      },
      // 新增、编辑
      handleEdit(row) {
        this.saveOrUpdateFormTitile = ''编辑''
        this.updateId = row.id
        this.saveOrUpdateForm = Object.assign({}, row)
        this.saveOrUpdateFormVisible = true
      },
      handleCreate() {
        this.saveOrUpdateFormTitile = ''新增''
        this.updateId = null
        this.saveOrUpdateForm = {}
        this.saveOrUpdateFormVisible = true
      },
      update${table.nameUpperCamel}() {
        this.saveOrUpdateLoading = true
        update(this.saveOrUpdateForm, this.updateId).then(() => {
          this.saveOrUpdateForm = {}
          this.saveOrUpdateFormVisible = false
          this.fetchData()
          showSuccessDialog(this)
          this.saveOrUpdateLoading = false
        }).catch(() => {
          this.saveOrUpdateLoading = false
        })
      },
      save${table.nameUpperCamel}() {
        this.saveOrUpdateLoading = true
        save(this.saveOrUpdateForm).then(() => {
          this.saveOrUpdateForm = {}
          this.saveOrUpdateFormVisible = false
          this.fetchData()
          showSuccessDialog(this)
          this.saveOrUpdateLoading = false
        }).catch(() => {
          this.saveOrUpdateLoading = false
        })
      },
      saveOrUpdate${table.nameUpperCamel}() {
        this.$refs[this.saveOrUpdateFormRef].validate((valid) => {
          if (valid) {
            this.updateId == null ? this.save${table.nameUpperCamel}() : this.update${table.nameUpperCamel}()
          }
        })
      },
      // 删除
      handleDelete(row) {
        showDeleteDialog(this, () => {
          remove(row.id).then(() => {
            this.fetchData()
            showSuccessDialog(this)
          })
        })
      }
    }
  }
</script>','index.vue','views/${table.nameLower}',2,NULL,'2022-12-20 22:44:42.471+08','2022-12-20 23:46:01.129+08'),
	 ('api','import request from ''@/utils/request''

export function query(params) {
  return request({
    url: ''/${table.nameLowerCamel}/query'',
    method: ''get'',
    params
  })
}

export function save(params) {
  return request({
    url: ''/${table.nameLowerCamel}/save'',
    method: ''post'',
    data: params
  })
}

export function update(params, id) {
  return request({
    url: `/${table.nameLowerCamel}/update/${r''${id}''}`,
    method: ''put'',
    data: params
  })
}

export function remove(id) {
  return request({
    url: `/${table.nameLowerCamel}/remove/${r''${id}''}`,
    method: ''delete''
  })
}
','${table.nameLowerCamel}.js','api',2,NULL,'2022-12-20 23:04:13.709+08','2022-12-20 23:44:16.485+08'),
	 ('route','{
	path: ''${table.nameLowerHyphen}'',
	name: ''${table.nameUpperCamel}'',
	component: () => import(''@/views/${table.nameLowerCamel}/index''),
	meta: { title: ''${table.comment}'', icon: ''table'' }
}','${table.nameLowerCamel}Index.js','api/router',2,NULL,'2022-12-20 23:56:28.535+08','2022-12-21 00:03:12.708+08');
