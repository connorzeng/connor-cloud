package com.connor.cloud.provider.controller;

import com.connor.cloud.common.entity.ResponseResult;
import com.connor.cloud.provider.service.SampleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/sample")
@DubboService(version = "0.0.1")
public class SampleController implements SampleService {


    //@GetMapping("/doRequest")
    public ResponseResult<String> doRequest() {
        return ResponseResult.success("请求成功");
    }

}
