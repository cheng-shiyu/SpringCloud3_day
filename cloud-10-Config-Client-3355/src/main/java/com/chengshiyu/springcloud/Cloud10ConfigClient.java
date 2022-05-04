package com.chengshiyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

/**
 * @author 程世玉
 * @data 2022/5/4.
 */
@SpringBootApplication
@EnableEurekaClient
public class Cloud10ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(Cloud10ConfigClient.class,args);
    }
}
