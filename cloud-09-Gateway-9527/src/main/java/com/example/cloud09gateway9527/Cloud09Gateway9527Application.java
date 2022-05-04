package com.example.cloud09gateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Cloud09Gateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud09Gateway9527Application.class, args);
    }

}
