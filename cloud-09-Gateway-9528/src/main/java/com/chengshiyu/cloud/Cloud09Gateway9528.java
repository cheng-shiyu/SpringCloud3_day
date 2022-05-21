package com.chengshiyu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 开启服务注册中心
@EnableEurekaClient
public class Cloud09Gateway9528 {

    public static void main(String[] args) {
        SpringApplication.run(Cloud09Gateway9528.class, args);
    }

}
