package com.yy.springbootdubbo01.provider.controller;

import com.yy.springbootdubbo01.provider.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;


    @GetMapping("/user")
    public String getUser() {
        return userServiceImpl.getUser();
    }
}
