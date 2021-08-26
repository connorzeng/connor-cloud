package com.connor.cloud.comsumer.controller;


import com.connor.cloud.common.entity.ResponseResult;
import com.connor.cloud.demo.common.EchoService;
import com.connor.cloud.demo.common.SamplerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SamplerConsumerController {


    @DubboReference
    private EchoService echoService;

    @DubboReference(version = "0.0.1")
    private SamplerService samplerService;


    @GetMapping("/doRequest")
    public ResponseResult<String> doRequest() {

       echoService.echo("");
       return  null;
    }

    @GetMapping("/doRequest2")
    public ResponseResult<String> doRequest2() {

        samplerService.doRequest();
        return  null;
    }



}
