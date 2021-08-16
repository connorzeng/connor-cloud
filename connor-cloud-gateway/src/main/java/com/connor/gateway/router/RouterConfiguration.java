package com.connor.gateway.router;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RouterConfiguration {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes().route(r -> r.order(1).alwaysTrue().uri("http://localhost:8080/"))
                .route("memberService",r -> r.order(-1).method(HttpMethod.GET).and().uri("http://localhost:8080/"))
                .build();
    }


}
