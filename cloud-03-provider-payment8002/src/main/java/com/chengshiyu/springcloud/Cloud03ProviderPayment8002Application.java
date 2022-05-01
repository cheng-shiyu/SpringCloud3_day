package com.chengshiyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication()
@EnableEurekaClient
public class Cloud03ProviderPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud03ProviderPayment8002Application.class, args);
    }

}
