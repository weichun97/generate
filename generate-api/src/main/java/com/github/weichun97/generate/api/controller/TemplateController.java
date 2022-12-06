package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.param.template.SaveOrUpdateDetailParam;
import com.github.weichun97.generate.api.pojo.vo.template.ListDetailVO;
import com.github.weichun97.generate.api.service.TemplateService;
import com.github.weichun97.generate.common.api.Response;
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

    @ApiOperation("获取模板详情列表")
    @GetMapping("listDetail/{id}")
    public Response<List<ListDetailVO>> listDetail(@PathVariable Long id){
        return Response.success(templateService.listDetail(id));
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
