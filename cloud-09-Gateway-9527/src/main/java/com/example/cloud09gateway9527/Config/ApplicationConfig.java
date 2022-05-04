package com.example.cloud09gateway9527.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 程世玉
 * @data 2022/5/3.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        /*生成一个routes路由*/
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("csy-test", r ->
            r.path("/guonei")
                    .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
