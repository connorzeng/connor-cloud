package com.connor.cloud.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.connor.cloud.common","com.connor.cloud.admin"})
public class ServerBoot {


    public static void main(String[] args) {
        SpringApplication.run(ServerBoot.class);
    }
}
