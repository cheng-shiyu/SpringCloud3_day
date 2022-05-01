package com.chengshiyu.springcloud.Config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 程世玉
 * @data 2022/4/28.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
