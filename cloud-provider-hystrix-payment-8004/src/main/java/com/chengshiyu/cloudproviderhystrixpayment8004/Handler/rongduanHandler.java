package com.chengshiyu.cloudproviderhystrixpayment8004.Handler;

import com.chengshiyu.cloudproviderhystrixpayment8004.Service.UserService;
import com.chengshiyu.springcloud.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/2.
 */
@RestController
public class rongduanHandler {
    @Autowired
    private UserService userService;
    @GetMapping("/rd/t1")
    public R t1(@RequestParam("num") Integer num){
        return userService.t1(num);
    }


    @GetMapping("/rd/t2")
    public R t2(){
        return userService.t2();
    }


    @GetMapping("/rd/t3")
    public R t3(){
        return userService.t3();
    }

}
