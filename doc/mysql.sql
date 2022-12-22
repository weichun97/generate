drop table if exists tl_template;
CREATE TABLE `tl_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(50) NOT NULL COMMENT '模板组名',
    `base_dir` varchar(100) DEFAULT NULL COMMENT '基础文件夹',
    `custom_field` mediumtext COMMENT '自定义字段',
    `remark` varchar(100) DEFAULT NULL COMMENT '备注',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板组';

drop table if exists tl_template_detail;
CREATE TABLE `tl_template_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(100) NOT NULL COMMENT '模板名',
    `content` mediumtext NOT NULL COMMENT '内容',
    `file_name` varchar(100) NOT NULL COMMENT '文件名',
    `dir` varchar(200) DEFAULT NULL COMMENT '目录',
    `template_id` bigint(20) NOT NULL COMMENT '模板组id',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板';

drop table if exists tl_datasource;
CREATE TABLE `tl_datasource` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `host` varchar(50) NOT NULL COMMENT 'host',
    `port` int(11) NOT NULL COMMENT '端口号',
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `db_name` varchar(50) NOT NULL COMMENT '数据库名',
    `db_type` int(11) NOT NULL COMMENT '数据库类型',
    `del_prefix` varchar(100) DEFAULT NULL COMMENT '删除的表前缀',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源';

INSERT INTO `tl_template`(`id`, `name`, `base_dir`, `custom_field`, `remark`, `create_time`, `update_time`, `delete_time`) VALUES (1, 'demo-java', 'com/itran/fgoc/server/sys', '[{\"key\":\"author\",\"value\":\"chun\"}]', 'demo项目git地址:https://github.com/weichun97/web-template.git', '2022-12-21 18:05:12', NULL, NULL);
INSERT INTO `tl_template`(`id`, `name`, `base_dir`, `custom_field`, `remark`, `create_time`, `update_time`, `delete_time`) VALUES (2, 'demo-vue-element', NULL, NULL, 'demo项目git地址:https://github.com/weichun97/vue-admin-template.git', '2022-12-21 18:05:41', NULL, NULL);

INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (1, 'po', 'package ${base.packageName};\r\n\r\n\r\nimport com.baomidou.mybatisplus.annotation.*;\r\nimport lombok.AllArgsConstructor;\r\nimport lombok.Builder;\r\nimport lombok.Data;\r\nimport lombok.NoArgsConstructor;\r\n\r\nimport java.util.Date;\r\n\r\n@Data\r\n@Builder\r\n@TableName(\"${table.name}\")\r\n@NoArgsConstructor\r\n@AllArgsConstructor\r\npublic class ${table.nameUpperCamel}Entity {\r\n  \r\n  	<#list columns as column>\r\n    /**\r\n   	 * ${column.comment}\r\n   	 */\r\n    <#if column.primaryFlag == 1>\r\n    @TableId<#if column.autoFlag == 1>(type = IdType.AUTO)</#if>\r\n  	<#else>\r\n    @TableField(value = \"${column.name}\"<#if column.name == \"create_time\">, fill = FieldFill.INSERT</#if><#if column.name == \"update_time\">, fill = FieldFill.UPDATE</#if>) \r\n  	</#if>\r\n  	<#if column.name == \"delete_time\">\r\n    @TableLogic(value = \"null\", delval = \"now()\")\r\n  	</#if>\r\n  	private ${column.boxType} ${column.nameLowerCamel};\r\n  \r\n  	</#list>\r\n}\r\n', '${table.nameUpperCamel}Entity.java', '${base.baseDir}/entity/po', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (4, 'saveOrUpdateParam', 'package ${base.packageName};\r\n\r\nimport io.swagger.annotations.ApiModel;\r\nimport io.swagger.annotations.ApiModelProperty;\r\nimport lombok.Data;\r\n\r\nimport java.util.Date;\r\n\r\n@Data\r\n@ApiModel(\"${base.packageName}.${table.nameUpperCamel}SaveOrUpdateParam\")\r\npublic class ${table.nameUpperCamel}SaveOrUpdateParam {\r\n  \r\n  	<#list columns as column>\r\n    <#if column.name != \"id\" && column.name != \"create_time\" && column.name != \"update_time\" && column.name != \"delete_time\">\r\n    @ApiModelProperty(value = \"${column.comment}\", example = \"\")\r\n  	private ${column.boxType} ${column.nameLowerCamel};\r\n  \r\n    </#if>\r\n  	</#list>\r\n}\r\n', '${table.nameUpperCamel}SaveOrUpdateParam.java', '${base.baseDir}/entity/param/${table.nameLower}', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (6, 'queryParam', 'package ${base.packageName};\r\n\r\nimport io.swagger.annotations.ApiModel;\r\nimport io.swagger.annotations.ApiModelProperty;\r\nimport lombok.Data;\r\n\r\nimport java.util.Date;\r\n\r\n@Data\r\n@ApiModel(\"${base.packageName}.${table.nameUpperCamel}QueryParam\")\r\npublic class ${table.nameUpperCamel}QueryParam {\r\n  \r\n  	<#list columns as column>\r\n    <#if column.name != \"id\" && column.name != \"create_time\" && column.name != \"update_time\" && column.name != \"delete_time\">\r\n    @ApiModelProperty(value = \"${column.comment}\", example = \"\")\r\n  	private ${column.boxType} ${column.nameLowerCamel};\r\n  \r\n    </#if>\r\n  	</#list>\r\n}', '${table.nameUpperCamel}QueryParam.java', '${base.baseDir}/entity/param/${table.nameLower}', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (7, 'queryVO', 'package ${base.packageName};\r\n\r\nimport io.swagger.annotations.ApiModel;\r\nimport io.swagger.annotations.ApiModelProperty;\r\nimport lombok.Data;\r\n\r\nimport java.util.Date;\r\n\r\n@Data\r\n@ApiModel(\"${base.packageName}.${table.nameUpperCamel}QueryVO\")\r\npublic class ${table.nameUpperCamel}QueryVO {\r\n  \r\n  	<#list columns as column>\r\n    <#if column.name != \"update_time\" && column.name != \"delete_time\">\r\n    @ApiModelProperty(value = \"${column.comment}\", example = \"\")\r\n  	private ${column.boxType} ${column.nameLowerCamel};\r\n  \r\n    </#if>\r\n  	</#list>\r\n}\r\n', '${table.nameUpperCamel}QueryVO.java', '${base.baseDir}/entity/vo/${table.nameLower}', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (9, 'dao', 'package ${base.packageName};\r\n\r\nimport com.baomidou.mybatisplus.core.mapper.BaseMapper;\r\nimport ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;\r\nimport ${base.basePackageName}.entity.param.${table.nameLower}.${table.nameUpperCamel}QueryParam;\r\nimport ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;\r\nimport com.itran.fgoc.common.mybatisplus.FgocPage;\r\nimport org.apache.ibatis.annotations.Mapper;\r\nimport org.apache.ibatis.annotations.Param;\r\n\r\n@Mapper\r\npublic interface ${table.nameUpperCamel}Dao extends BaseMapper<${table.nameUpperCamel}Entity> {\r\n\r\n    /**\r\n     * 分页\r\n     */\r\n    FgocPage<${table.nameUpperCamel}QueryVO> query(FgocPage<${table.nameUpperCamel}QueryVO> fgocPage, @Param(\"queryParam\") ${table.nameUpperCamel}QueryParam queryParam);\r\n}', '${table.nameUpperCamel}Dao.java', '${base.baseDir}/entity/dao', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (10, 'mapper', 'package ${base.packageName};\r\n\r\nimport ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;\r\nimport ${base.basePackageName}.entity.param.${table.nameLower}.${table.nameUpperCamel}SaveOrUpdateParam;\r\nimport org.mapstruct.Mapper;\r\n\r\n@Mapper(componentModel = \"spring\")\r\npublic interface ${table.nameUpperCamel}Mapper {\r\n\r\n    ${table.nameUpperCamel}Entity saveOrUpdateParamToPo(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);\r\n}\r\n', '${table.nameUpperCamel}Mapper.java', '${base.baseDir}/entity/mapper', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (11, 'service', 'package ${base.packageName};\r\n\r\nimport com.baomidou.mybatisplus.extension.service.IService;\r\nimport ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;\r\nimport ${base.basePackageName}.entity.param.${table.nameLower}.*;\r\nimport ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;\r\nimport com.itran.fgoc.common.mybatisplus.FgocPage;\r\nimport com.itran.fgoc.common.mybatisplus.PageParam;\r\n\r\npublic interface ${table.nameUpperCamel}Service extends IService<${table.nameUpperCamel}Entity> {\r\n\r\n    /**\r\n     * ${table.comment}分页\r\n\r\n     * @param pageParam\r\n     * @param queryParam\r\n     * @return\r\n     */\r\n    FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam queryParam);\r\n\r\n    /**\r\n     * 保存${table.comment}\r\n     * @param saveOrUpdateParam\r\n     */\r\n    void save(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);\r\n\r\n    /**\r\n     * 更新${table.comment}\r\n     * @param id\r\n     * @param saveOrUpdateParam\r\n     */\r\n    void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam);\r\n\r\n    /**\r\n     * 删除${table.comment}\r\n     * @param id\r\n     */\r\n    void remove(Long id);\r\n}\r\n', '${table.nameUpperCamel}Service.java', '${base.baseDir}/service', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (12, 'serviceImpl', 'package ${base.packageName};\r\n\r\nimport ${base.basePackageName}.entity.po.${table.nameUpperCamel}Entity;\r\nimport ${base.basePackageName}.entity.mapper.${table.nameUpperCamel}Mapper;\r\nimport ${base.basePackageName}.entity.dao.${table.nameUpperCamel}Dao;\r\nimport ${base.basePackageName}.entity.param.${table.nameLower}.*;\r\nimport ${base.basePackageName}.service.${table.nameUpperCamel}Service;\r\nimport ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;\r\nimport com.itran.fgoc.common.mybatisplus.FgocPage;\r\nimport com.itran.fgoc.common.mybatisplus.PageParam;\r\nimport com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;\r\nimport org.springframework.stereotype.Service;\r\nimport com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;\r\nimport javax.annotation.Resource;\r\n\r\n@Service\r\npublic class ${table.nameUpperCamel}ServiceImpl extends ServiceImpl<${table.nameUpperCamel}Dao, ${table.nameUpperCamel}Entity> implements ${table.nameUpperCamel}Service {\r\n\r\n    @Resource\r\n    private ${table.nameUpperCamel}Mapper mapper;\r\n\r\n    @Override\r\n    public FgocPage<${table.nameUpperCamel}QueryVO> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam queryParam) {\r\n        return baseMapper.query(FgocPage.getPage(pageParam), queryParam);\r\n    }\r\n\r\n    @Override\r\n    public void save(${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam) {\r\n        save(mapper.saveOrUpdateParamToPo(saveOrUpdateParam));\r\n    }\r\n\r\n    @Override\r\n    public void update(Long id, ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam) {\r\n        update(mapper.saveOrUpdateParamToPo(saveOrUpdateParam),\r\n                new LambdaQueryWrapper<${table.nameUpperCamel}Entity>().eq(${table.nameUpperCamel}Entity::getId, id));\r\n    }\r\n\r\n    @Override\r\n    public void remove(Long id) {\r\n        removeById(id);\r\n    }\r\n}\r\n', '${table.nameUpperCamel}ServiceImpl.java', '${base.baseDir}/service/impl', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (14, 'controller', 'package ${base.packageName};\r\n\r\nimport ${base.basePackageName}.entity.param.${table.nameLower}.*;\r\nimport ${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO;\r\nimport ${base.basePackageName}.service.${table.nameUpperCamel}Service;\r\nimport com.itran.fgoc.common.core.api.Response;\r\nimport com.itran.fgoc.common.mybatisplus.FgocPage;\r\nimport com.itran.fgoc.common.mybatisplus.PageParam;\r\nimport io.swagger.annotations.Api;\r\nimport io.swagger.annotations.ApiOperation;\r\nimport org.springframework.web.bind.annotation.*;\r\n\r\nimport javax.annotation.Resource;\r\nimport javax.validation.Valid;\r\n\r\n@Api(value = \"${table.nameUpperCamel}Controller\", tags = \"${table.comment}\")\r\n@RequestMapping(\"${table.nameLowerCamel}\")\r\n@RestController\r\npublic class ${table.nameUpperCamel}Controller {\r\n\r\n    @Resource\r\n    private ${table.nameUpperCamel}Service ${table.nameLowerCamel}Service;\r\n\r\n    @ApiOperation(\"${table.comment}列表分页\")\r\n    @GetMapping(\"query\")\r\n    public Response<FgocPage<${table.nameUpperCamel}QueryVO>> query(PageParam pageParam, ${table.nameUpperCamel}QueryParam ${table.nameLowerCamel}QueryParam) {\r\n        return Response.success(${table.nameLowerCamel}Service.query(pageParam, ${table.nameLowerCamel}QueryParam));\r\n    }\r\n\r\n    @ApiOperation(\"保存${table.comment}\")\r\n    @PostMapping(\"save\")\r\n    public Response save(@Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){\r\n        ${table.nameLowerCamel}Service.save(saveOrUpdateParam);\r\n        return Response.success();\r\n    }\r\n\r\n    @ApiOperation(\"更新${table.comment}\")\r\n    @PutMapping(\"update/{id}\")\r\n    public Response update(@PathVariable Long id, @Valid @RequestBody ${table.nameUpperCamel}SaveOrUpdateParam saveOrUpdateParam){\r\n        ${table.nameLowerCamel}Service.update(id, saveOrUpdateParam);\r\n        return Response.success();\r\n    }\r\n\r\n    @ApiOperation(\"删除${table.comment}\")\r\n    @DeleteMapping(\"remove/{id}\")\r\n    public Response remove(@PathVariable Long id){\r\n        ${table.nameLowerCamel}Service.remove(id);\r\n        return Response.success();\r\n    }\r\n}', '${table.nameUpperCamel}Controller.java', '${base.baseDir}/controller', 1, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (15, 'daoXml', '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n\n<mapper namespace=\"${base.basePackageName}.entity.dao.${table.nameUpperCamel}Dao\">\n\n    <select id=\"query\" resultType=\"${base.basePackageName}.entity.vo.${table.nameLower}.${table.nameUpperCamel}QueryVO\">\n        select \n  		<#list columns as column>\n  		<#if column.name != \'update_time\' && column.name != \'delete_time\'>\n  			t1.${column.name}<#sep>, </#sep>\n		</#if>\n        </#list> \n		from ${table.name} t1\n        <#list columns as column>\n        <#if column.name = \'delete_time\'>\n        <where>\n            t1.delete_time is null\n        </where>\n        </#if>  \n        </#list>\n        order by t1.id desc\n    </select>\n</mapper>', '${table.nameUpperCamel}Dao.xml', '${base.baseDir}/entity/dao', 1, NULL, '2022-12-14 15:31:00', '2022-12-22 15:44:17');
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (16, 'index', '<template>\r\n    <div class=\"app-container\">\r\n      <!-- 搜索 -->\r\n      <div class=\"filter-container\">\r\n        <el-input v-model=\"listParam.name\" placeholder=\"测试\" style=\"width: 200px;\" clearable class=\"filter-item\" />\r\n        <el-button class=\"filter-item\" type=\"primary\" icon=\"el-icon-search\" @click=\"handleFilter\">\r\n          查询\r\n        </el-button>\r\n        <el-button class=\"filter-item\" type=\"primary\" icon=\"el-icon-search\" @click=\"handleResetQuery\">\r\n          重置\r\n        </el-button>\r\n        <el-button class=\"filter-item\" style=\"margin-left: 10px;\" type=\"primary\" icon=\"el-icon-edit\" @click=\"handleCreate\">\r\n          新增\r\n        </el-button>\r\n      </div>\r\n  \r\n      <!-- 表格 -->\r\n      <el-table\r\n        v-loading=\"listLoading\"\r\n        :data=\"list\"\r\n        element-loading-text=\"Loading\"\r\n        border\r\n        fit\r\n        highlight-current-row\r\n      >\r\n        <el-table-column align=\"center\" label=\"序号\" width=\"95\">\r\n          <template slot-scope=\"scope\">\r\n            {{ scope.$index + 1 }}\r\n          </template>\r\n        </el-table-column>\r\n        <#list columns as column>\r\n        <#if column.name != \"id\" && column.name != \"create_time\" && column.name != \"update_time\" && column.name != \"delete_time\">\r\n        <#if column.baseType == \"Date\">\r\n        <el-table-column\r\n          align=\"center\"\r\n          prop=\"${column.nameLowerCamel}\"\r\n          label=\"${column.comment}\"\r\n          width=\"200\"\r\n        >\r\n          <template slot-scope=\"scope\">\r\n            <i class=\"el-icon-time\" />\r\n            <span>{{ scope.row.${column.nameLowerCamel} }}</span>\r\n          </template>\r\n        </el-table-column>\r\n        <#else>\r\n        <el-table-column label=\"${column.comment}\">\r\n          <template slot-scope=\"scope\">\r\n            {{ scope.row.${column.nameLowerCamel} }}\r\n          </template>\r\n        </el-table-column>\r\n        </#if>\r\n        </#if>\r\n        </#list>\r\n        <el-table-column fixed=\"right\" label=\"操作\" width=\"200\">\r\n          <template slot-scope=\"scope\">\r\n            <el-button\r\n              type=\"text\"\r\n              size=\"small\"\r\n              @click=\"handleEdit(scope.row)\"\r\n            >编辑</el-button>\r\n            <el-button\r\n              type=\"text\"\r\n              size=\"small\"\r\n              @click=\"handleDelete(scope.row)\"\r\n            >删除</el-button>\r\n          </template>\r\n        </el-table-column>\r\n      </el-table>\r\n  \r\n      <!-- 分页 -->\r\n      <Pagination :total=\"total\" :page.sync=\"listParam.current\" :limit.sync=\"listParam.size\" @pagination=\"fetchData\" />\r\n  \r\n      <!-- 新增更新弹框 -->\r\n      <el-dialog :title=\"saveOrUpdateFormTitile\" :visible.sync=\"saveOrUpdateFormVisible\">\r\n        <el-form\r\n          :ref=\"saveOrUpdateFormRef\"\r\n          :model=\"saveOrUpdateForm\"\r\n          status-icon\r\n          :rules=\"saveOrUpdateFormRules\"\r\n          label-width=\"100px\"\r\n        >\r\n        <#list columns as column>\r\n        <#if column.name != \"id\" && column.name != \"create_time\" && column.name != \"update_time\" && column.name != \"delete_time\">\r\n          <el-form-item label=\"${column.comment}\" prop=\"${column.nameLowerCamel}\">\r\n            <el-input\r\n              v-model=\"saveOrUpdateForm.${column.nameLowerCamel}\"\r\n              type=\"text\"\r\n              autocomplete=\"off\"\r\n            />\r\n          </el-form-item>\r\n        </#if>\r\n        </#list> \r\n          <el-form-item>\r\n            <el-button\r\n              type=\"primary\"\r\n              :loading=\"saveOrUpdateLoading\"\r\n              @click=\"saveOrUpdate${table.nameUpperCamel}()\"\r\n            >提交</el-button>\r\n            <el-button @click=\"saveOrUpdateFormVisible = false\">取消</el-button>\r\n          </el-form-item>\r\n        </el-form>\r\n      </el-dialog>\r\n    </div>\r\n  </template>\r\n  \r\n  <script>\r\n  import { query, save, update, remove } from \'@/api/${table.nameLowerCamel}\'\r\n  import Pagination from \'@/components/Pagination\'\r\n  import { showDeleteDialog, showSuccessDialog } from \'@/utils/common\'\r\n  \r\n  export default {\r\n    components: {\r\n      Pagination\r\n    },\r\n    data() {\r\n      return {\r\n        // 分页\r\n        total: 0,\r\n        listParam: {\r\n          current: 1,\r\n          size: 10\r\n        },\r\n        list: [],\r\n        listLoading: true,\r\n        // 新增、修改\r\n        saveOrUpdateLoading: false,\r\n        saveOrUpdateFormRef: \'saveOrUpdateFormRef\',\r\n        saveOrUpdateFormTitile: \'新增\',\r\n        saveOrUpdateFormVisible: false,\r\n        updateId: null,\r\n        saveOrUpdateForm: {\r\n          name: null\r\n        },\r\n        saveOrUpdateFormRules: {\r\n          name: [\r\n            { required: true, message: \'请输入模板名\', trigger: \'blur\' },\r\n            { min: 1, max: 20, message: \'长度在 1 到 20 个字符\', trigger: \'blur\' }\r\n          ]\r\n        }\r\n      }\r\n    },\r\n    created() {\r\n      this.fetchData()\r\n    },\r\n    methods: {\r\n      // 分页\r\n      handleFilter() {\r\n        this.fetchData()\r\n      },\r\n      handleResetQuery() {\r\n        this.listParam = {\r\n          current: 1,\r\n          size: 10\r\n        }\r\n        this.fetchData()\r\n      },\r\n      fetchData() {\r\n        this.listLoading = true\r\n        query(this.listParam).then((response) => {\r\n          this.list = response.data.records\r\n          this.total = response.data.total\r\n          this.listLoading = false\r\n        })\r\n      },\r\n      // 新增、编辑\r\n      handleEdit(row) {\r\n        this.saveOrUpdateFormTitile = \'编辑\'\r\n        this.updateId = row.id\r\n        this.saveOrUpdateForm = Object.assign({}, row)\r\n        this.saveOrUpdateFormVisible = true\r\n      },\r\n      handleCreate() {\r\n        this.saveOrUpdateFormTitile = \'新增\'\r\n        this.updateId = null\r\n        this.saveOrUpdateForm = {}\r\n        this.saveOrUpdateFormVisible = true\r\n      },\r\n      update${table.nameUpperCamel}() {\r\n        this.saveOrUpdateLoading = true\r\n        update(this.saveOrUpdateForm, this.updateId).then(() => {\r\n          this.saveOrUpdateForm = {}\r\n          this.saveOrUpdateFormVisible = false\r\n          this.fetchData()\r\n          showSuccessDialog(this)\r\n          this.saveOrUpdateLoading = false\r\n        }).catch(() => {\r\n          this.saveOrUpdateLoading = false\r\n        })\r\n      },\r\n      save${table.nameUpperCamel}() {\r\n        this.saveOrUpdateLoading = true\r\n        save(this.saveOrUpdateForm).then(() => {\r\n          this.saveOrUpdateForm = {}\r\n          this.saveOrUpdateFormVisible = false\r\n          this.fetchData()\r\n          showSuccessDialog(this)\r\n          this.saveOrUpdateLoading = false\r\n        }).catch(() => {\r\n          this.saveOrUpdateLoading = false\r\n        })\r\n      },\r\n      saveOrUpdate${table.nameUpperCamel}() {\r\n        this.$refs[this.saveOrUpdateFormRef].validate((valid) => {\r\n          if (valid) {\r\n            this.updateId == null ? this.save${table.nameUpperCamel}() : this.update${table.nameUpperCamel}()\r\n          }\r\n        })\r\n      },\r\n      // 删除\r\n      handleDelete(row) {\r\n        showDeleteDialog(this, () => {\r\n          remove(row.id).then(() => {\r\n            this.fetchData()\r\n            showSuccessDialog(this)\r\n          })\r\n        })\r\n      }\r\n    }\r\n  }\r\n</script>', 'index.vue', 'views/${table.nameLower}', 2, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (17, 'api', 'import request from \'@/utils/request\'\r\n\r\nexport function query(params) {\r\n  return request({\r\n    url: \'/${table.nameLowerCamel}/query\',\r\n    method: \'get\',\r\n    params\r\n  })\r\n}\r\n\r\nexport function save(params) {\r\n  return request({\r\n    url: \'/${table.nameLowerCamel}/save\',\r\n    method: \'post\',\r\n    data: params\r\n  })\r\n}\r\n\r\nexport function update(params, id) {\r\n  return request({\r\n    url: `/${table.nameLowerCamel}/update/${r\'${id}\'}`,\r\n    method: \'put\',\r\n    data: params\r\n  })\r\n}\r\n\r\nexport function remove(id) {\r\n  return request({\r\n    url: `/${table.nameLowerCamel}/remove/${r\'${id}\'}`,\r\n    method: \'delete\'\r\n  })\r\n}\r\n', '${table.nameLowerCamel}.js', 'api', 2, NULL, '2022-12-14 15:31:00', NULL);
INSERT INTO `tl_template_detail`(`id`, `name`, `content`, `file_name`, `dir`, `template_id`, `delete_time`, `create_time`, `update_time`) VALUES (18, 'route', '{\r\n	path: \'${table.nameLowerHyphen}\',\r\n	name: \'${table.nameUpperCamel}\',\r\n	component: () => import(\'@/views/${table.nameLowerCamel}/index\'),\r\n	meta: { title: \'${table.comment}\', icon: \'table\' }\r\n}', '${table.nameLowerCamel}Index.js', 'api/router', 2, NULL, '2022-12-14 15:31:00', NULL);