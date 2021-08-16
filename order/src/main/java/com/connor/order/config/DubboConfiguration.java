package com.connor.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DubboConfiguration {


    //实例化 RestTemplate 实例
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }


}
