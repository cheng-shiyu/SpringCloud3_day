package com.chengshiyu.cloudproviderhystrixpayment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix // 开启熔断
public class CloudProviderHystrixPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8004Application.class, args);
    }

}
