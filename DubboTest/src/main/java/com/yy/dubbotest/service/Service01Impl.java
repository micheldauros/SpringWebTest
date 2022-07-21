package com.yy.dubbotest.service;

import org.springframework.stereotype.Component;

@Component
@DubboService
public class Service01Impl implements Service01{
    @Override
    public void sayHello() {

    }
}
