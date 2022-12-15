package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.param.template.ListDetailParam;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.param.template.TemplateQueryParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.pojo.vo.template.TemplateQueryVO;
import com.github.weichun97.generate.api.service.TemplateService;
import com.github.weichun97.generate.common.api.Response;
import com.github.weichun97.generate.common.api.SelectVO;
import com.github.weichun97.generate.common.mybatis.GeneratePage;
import com.github.weichun97.generate.common.mybatis.GeneratePageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:37
 */
@Api(value = "TemplateController", tags = "模板")
@RequestMapping("template")
@RestController
public class TemplateController {

    @Resource
    private TemplateService templateService;

    @ApiOperation("模板列表分页")
    @GetMapping("query")
    public Response<GeneratePage<TemplateQueryVO>> query(GeneratePageParam pageParam, TemplateQueryParam templateQueryParam) {
        return Response.success(templateService.query(pageParam, templateQueryParam));
    }

    @ApiOperation("模板列表下拉")
    @GetMapping("select")
    public Response<List<SelectVO>> select() {
        return Response.success(templateService.select());
    }

    @ApiOperation("保存模板")
    @PostMapping("save")
    public Response save(@Valid @RequestBody SaveOrUpdateParam saveOrUpdateParam){
        templateService.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新模板")
    @PutMapping("update/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody SaveOrUpdateParam saveOrUpdateParam){
        templateService.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除模板")
    @DeleteMapping("remove/{id}")
    public Response remove(@PathVariable Long id){
        templateService.remove(id);
        return Response.success();
    }

    @ApiOperation("获取模板详情列表")
    @GetMapping("listDetail")
    public Response<List<ListDetailVO>> listDetail(ListDetailParam listDetailParam){
        return Response.success(templateService.listDetail(listDetailParam));
    }

    @ApiOperation("保存模板详情")
    @PostMapping("saveDetail")
    public Response saveDetail(@Valid @RequestBody SaveOrUpdateDetailParam saveOrUpdateDetailParam){
        templateService.saveDetail(saveOrUpdateDetailParam);
        return Response.success();
    }

    @ApiOperation("更新模板详情")
    @PutMapping("updateDetail/{id}")
    public Response updateDetail(@PathVariable Long id, @Valid @RequestBody SaveOrUpdateDetailParam saveOrUpdateDetailParam){
        templateService.updateDetail(id, saveOrUpdateDetailParam);
        return Response.success();
    }

    @ApiOperation("删除模板详情")
    @DeleteMapping("removeDetail/{id}")
    public Response removeDetail(@PathVariable Long id){
        templateService.removeDetail(id);
        return Response.success();
    }
}
