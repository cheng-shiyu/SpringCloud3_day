package com.chengshiyu.cloudproviderhystrixpayment8004.Service;

import com.chengshiyu.springcloud.entity.R;

/**
 * @author 程世玉
 * @data 2022/5/2.
 */
public interface UserService {
    /*执行方法*/
    R t1(Integer num);

    /*超时错误*/
    R t2();

    /*正常业务*/
    R t3();
}
