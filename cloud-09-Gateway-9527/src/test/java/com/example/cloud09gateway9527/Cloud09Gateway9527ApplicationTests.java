package com.example.cloud09gateway9527;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

class Cloud09Gateway9527ApplicationTests {

    @Test
    void contextLoads() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
//        2022-05-03T17:21:51.859+08:00[Asia/Shanghai]
    }

}
