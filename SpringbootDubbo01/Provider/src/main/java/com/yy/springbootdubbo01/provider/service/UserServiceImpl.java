package com.yy.springbootdubbo01.provider.service;

import com.yy.springbootdubbo01.interface01.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    public String getUser() {
        return "hello";
    }
}
