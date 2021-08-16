package com.connor.order.controller;

import com.connor.order.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Controller 需要添加 ResponseBody
//RestController = (Controller + ResponseBody)
@RestController
public class OrderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberService memberService;

    @Value("${spring.application.name}")
    private String appName;


    @RequestMapping("/submitOrder")
    public String registMember() {


        // 直接URL调用远程接口
        getResultByUrl();

        // 通过FeignService调用
        getResultByFeignService();


        return "registMember ...";
    }


    private void getResultByUrl() {
        String url = null;
        try {
            //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
            ServiceInstance serviceInstance = loadBalancerClient.choose("member");
            url = String.format("http://%s:%s/test", serviceInstance.getHost(), serviceInstance.getPort());
            System.out.println("request url:" + url);
            String result = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getResultByFeignService() {

        try {
            String s = memberService.notFound();
            String divide = memberService.divide(2, 1);
            String echo = memberService.echo(appName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/qryOrder")
    public String qryOrder() {

        return "qryMember ...";
    }
}
