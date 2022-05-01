package com.chengshiyu.springcloud.Service;

import com.chengshiyu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 程世玉
 * @data 2022/5/1.
 */
@Component  // 不要忘记
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = hystrixServiceImpl.class)
public interface hystrixService {
    @GetMapping("/hystrix/t1")
     CommonResult<String> t1();

    @GetMapping("/hystrix/t2")
     CommonResult<String> t2();

    /*报错*/
    @GetMapping("/hystrix/t3")
    public CommonResult<String> t3();
}
