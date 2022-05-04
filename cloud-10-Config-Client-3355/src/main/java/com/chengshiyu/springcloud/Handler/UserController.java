package com.chengshiyu.springcloud.Handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/4.
 */
@RestController
@RefreshScope  // 加入这个注解，我们就可以通过命令局部刷新这个Controller
public class UserController {
    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/client/t1")
    public String t1(){
        return port + "----" + info;
    }
}
