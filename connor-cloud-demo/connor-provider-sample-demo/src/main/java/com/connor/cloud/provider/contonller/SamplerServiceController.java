package com.connor.cloud.provider.contonller;

import com.connor.cloud.common.entity.ResponseResult;
import com.connor.cloud.demo.common.SamplerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DubboService(version = "0.0.1")
@Api("sample")
public class SamplerServiceController implements SamplerService {

    @ApiOperation(value = "测试请求", notes = "测试请求")
    @ApiResponses(@ApiResponse(code = 000000, message = "处理成功", response = ResponseResult.class))
    @GetMapping("/doRequest")
    public ResponseResult<String> doRequest() {
        return ResponseResult.success("请求成功");
    }

}
