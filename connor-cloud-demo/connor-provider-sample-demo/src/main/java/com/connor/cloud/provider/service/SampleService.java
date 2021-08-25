package com.connor.cloud.provider.service;

import com.connor.cloud.common.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;

public interface SampleService {

    //@GetMapping("/doRequest")
    public ResponseResult<String> doRequest();

}
