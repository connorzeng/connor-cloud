package com.connor.cloud.provider;

import com.connor.cloud.demo.common.EchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class EchoServiceImpl implements EchoService {


    @RequestMapping("test")
    @Override
    public String echo(String message) {
        return "[echo] Hello, " + message;
    }
}
