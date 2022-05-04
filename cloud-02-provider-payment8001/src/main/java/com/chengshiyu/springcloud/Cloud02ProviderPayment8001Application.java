package com.chengshiyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Cloud02ProviderPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Cloud02ProviderPayment8001Application.class, args);
    }

}
