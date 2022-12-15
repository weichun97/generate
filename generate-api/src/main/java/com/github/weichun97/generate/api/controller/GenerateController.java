package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.param.generate.GenerateParam;
import com.github.weichun97.generate.api.pojo.vo.generate.GenerateVO;
import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;
import com.github.weichun97.generate.api.service.GenerateService;
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
@Api(value = "GenerateController", tags = "代码生成器")
@RequestMapping("/generate")
@RestController
public class GenerateController {

    @Resource
    GenerateService generateService;

    @GetMapping("/tables/{datasourceId}")
    @ApiOperation(value = "数据表列表")
    public Response<List<TablesVO>> tables(@PathVariable Long datasourceId){
        return Response.success(generateService.tables(datasourceId));
    }

    @GetMapping("/types")
    @ApiOperation(value = "生成文件类型")
    public Response<List<String>> types(){
        return Response.success(generateService.types());
    }

    @PostMapping("/generate")
    @ApiOperation(value = "生成代码")
    public Response<List<GenerateVO>> generate(@Valid @RequestBody GenerateParam generateParam){
        return Response.success(generateService.generate(generateParam));
    }
}
