package com.chengshiyu.springcloud.Handler;

import cn.hutool.core.lang.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
public class UserController {

    @GetMapping(value = "/zk/t1")
    public String paymentzk(HttpServletRequest request) {
        int serverPort = request.getServerPort();
        return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
