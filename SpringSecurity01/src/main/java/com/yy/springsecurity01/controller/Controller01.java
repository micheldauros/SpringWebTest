package com.yy.springsecurity01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller01 {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello, Spring Security";
    }

    @RequestMapping("/hello2")
    public String hell02(){
        return "Hello2, Spring Security";
    }
}
