package com.github.weichun97.generate.api.controller;

import com.github.weichun97.generate.api.pojo.vo.generate.GenerateReqVO;
import com.github.weichun97.generate.api.pojo.vo.generate.ListResVO;
import com.github.weichun97.generate.api.service.GenerateService;
import com.github.weichun97.generate.common.api.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/tables")
    @ApiOperation(value = "数据表列表")
    public Response<List<ListResVO>> list(){
        return Response.success(generateService.listQuery());
    }

    @GetMapping("/types")
    @ApiOperation(value = "生成文件类型")
    public Response<List<String>> types(){
        return Response.success(generateService.types());
    }

    @PostMapping("/generate")
    @ApiOperation(value = "生成代码")
    public Response generate(GenerateReqVO generateReqVO){
        generateService.generate(generateReqVO);
        return Response.success();
    }
}
