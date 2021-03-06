package com.connor.cloud.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerBoot {

    public static void main(String[] args) {
        SpringApplication.run(ServerBoot.class);
    }

}
