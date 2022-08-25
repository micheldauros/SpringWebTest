package com.yy.miscellaneous.controller;

import com.yy.miscellaneous.timer.TimerAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    @TimerAspect// 不可以在controller上添加aop注解，因为生产的代理类不是bean，不被容器管理，因此返回值不会传递到前端
    public String hello() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello timer");
        String nacoss="haha";
        System.out.println(nacoss);
        return "hello timer";


    }
}
