package com.chengshiyu.springcloud.Handler;

import com.chengshiyu.springcloud.Service.hystrixService;
import com.chengshiyu.springcloud.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 程世玉
 * @data 2022/5/2.
 */
@RestController
public class ronduanController {
    @Autowired
    private hystrixService hystrixService;

    @GetMapping("/rd/t1")
    public R t1(Integer num){
        return hystrixService.t1(num);
    }
}
