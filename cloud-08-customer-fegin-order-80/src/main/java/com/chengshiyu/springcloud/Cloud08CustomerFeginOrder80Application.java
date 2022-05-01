package com.chengshiyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients // 开启openFegin
public class Cloud08CustomerFeginOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud08CustomerFeginOrder80Application.class, args);
    }

}
