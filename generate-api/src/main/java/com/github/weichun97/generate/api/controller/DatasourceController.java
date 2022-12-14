package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.param.datasource.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;
import com.github.weichun97.generate.api.service.DatasourceService;
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
@Api(value = "DatasourceController", tags = "数据源")
@RequestMapping("/datasource")
@RestController
public class DatasourceController {

    @Resource
    private DatasourceService datasourceService;

    @GetMapping("/list")
    @ApiOperation(value = "数据源列表")
    public Response<List<ListVO>> list(){
        return Response.success(datasourceService.listQuery());
    }

    @ApiOperation("保存数据源")
    @PostMapping("save")
    public Response save(@Valid @RequestBody SaveOrUpdateParam saveOrUpdateParam){
        datasourceService.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新模板")
    @PutMapping("update/{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody SaveOrUpdateParam saveOrUpdateParam){
        datasourceService.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除数据源")
    @DeleteMapping("remove/{id}")
    public Response remove(@PathVariable Long id){
        datasourceService.remove(id);
        return Response.success();
    }
}
