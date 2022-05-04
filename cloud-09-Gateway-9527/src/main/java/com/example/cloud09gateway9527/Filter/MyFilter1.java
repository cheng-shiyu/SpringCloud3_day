package com.example.cloud09gateway9527.Filter;

import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author 程世玉
 * @data 2022/5/4.
 */
@Component // 这个必须有，无论我们写什么组件，都要放入容器中
@Slf4j
public class MyFilter1 implements GlobalFilter, Ordered {
    /*Mono是一个对象，我们可以类似于ModelAndView*/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("MyFilter执行操作：" + DateTime.now());

        // 验证你是否有账号登录
        MultiValueMap<String, String> map = exchange.getRequest().getQueryParams();
        String username = map.getFirst("username");
        if (username == null){
            log.error("username字段是必须传递的，请先传递过来！！！");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.EXPECTATION_FAILED);

            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /*这个值越小越考前*/
    @Override
    public int getOrder() {
        return 0;
    }
}