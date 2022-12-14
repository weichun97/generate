package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;
import com.github.weichun97.generate.api.pojo.vo.generate.ListResVO;
import com.github.weichun97.generate.api.service.DatasourceService;
import com.github.weichun97.generate.common.api.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
