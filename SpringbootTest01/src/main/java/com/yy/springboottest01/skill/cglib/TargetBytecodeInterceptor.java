package com.yy.springboottest01.skill.cglib;

import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetBytecodeInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
