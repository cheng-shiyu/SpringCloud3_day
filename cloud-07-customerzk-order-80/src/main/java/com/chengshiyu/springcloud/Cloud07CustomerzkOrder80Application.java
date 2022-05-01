package com.chengshiyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloud07CustomerzkOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud07CustomerzkOrder80Application.class, args);
    }

}
