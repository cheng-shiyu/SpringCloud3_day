package com.chengshiyu.cloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author 程世玉
 * @data 2022/5/15.
 * 网关配置类
 */
@Configuration
public class myconfig {
    @Bean
    public RouteLocator routeLocator1(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        return routes.route("route1", r ->
                r.path("/route1/**").uri("http://124.223.86.21:8006/")
        ).build();
    }


    @Bean
    public RouteLocator routeLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        return routes.route("/route2", new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("/route2/**").uri("http://124.223.86.21/");
            }
        }).build();
    }

}
