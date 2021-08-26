package com.connor.cloud.comsumer.controller;


import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.connor.cloud.common.entity.ResponseResult;
import com.connor.cloud.demo.common.SamplerService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class SamplerConsumerController {


    /**
     * 基于Service进行请求
     */
    @DubboReference(version = "0.0.1")
    private SamplerService samplerService;


    @Autowired
    private DubboFeignRestService dubboFeignRestService;



    @GetMapping("/consumer1")
    public ResponseResult<String> consumer1() {

        samplerService.doRequest();

        return  null;
    }

    @GetMapping("/consumer2")
    public ResponseResult<String> consumer2() {

        ResponseResult<String> stringResponseResult = dubboFeignRestService.doRequest();
        return  stringResponseResult;
    }

    /**
     * 1. 配置@EnableFeignClients
     * 2. 配置spring-cloud-starter-openfeign
     */
    @FeignClient("connor-provider-sample-demo")
    @DubboTransported(protocol = "dubbo")
    public interface DubboFeignRestService {
        @GetMapping("/doRequest")
        public ResponseResult<String> doRequest();
    }



}
