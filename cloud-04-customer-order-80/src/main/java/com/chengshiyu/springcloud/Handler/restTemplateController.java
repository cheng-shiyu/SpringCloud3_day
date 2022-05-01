package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.entity.CommonResult;
import com.chengshiyu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 程世玉
 * @data 2022/4/26.
 */
@RestController
public class restTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String DEFAULT_PATH = "http://cloud-payment-service";

    @GetMapping("r1/t1")
    public CommonResult t1(String t){
        String path = DEFAULT_PATH + "/user/t1?t=" + t;
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(path, CommonResult.class);
        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getStatusCodeValue());
        System.out.println(forEntity.getBody());
        System.out.println(forEntity.getHeaders());
        return forEntity.getBody();
    }

    @GetMapping("r1/t2")
    public CommonResult t2(String t){
        String path = DEFAULT_PATH + "/user/t1?t=" + t;
        return restTemplate.getForObject(path, CommonResult.class);
    }

    @PostMapping("r1/t3")
    public CommonResult t3(@RequestBody Payment payment){
        String path = DEFAULT_PATH + "/user/t2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("Accept","application/json");

        HttpEntity httpEntity = new HttpEntity<>(payment, headers);
        return restTemplate.postForObject(path,httpEntity, CommonResult.class);
    }



    @PostMapping("r1/t4")
    public CommonResult t4(@RequestBody Payment payment){
        String path = DEFAULT_PATH + "/user/t2";
        return restTemplate.postForObject(path,payment, CommonResult.class);
    }
}
