package com.chengshiyu.springcloud.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
public class t1 {

    @Autowired
    private RestTemplate restTemplate;

    static final String INVOKE_URL = "http://cloud-provider-payment";
    @GetMapping("/zk/t1")
    public String s(){
        String s = restTemplate.getForObject(INVOKE_URL + "/zk/t1", String.class);
        System.out.println("消费者调用服务者进行共工作");
        return s;
    }
}
