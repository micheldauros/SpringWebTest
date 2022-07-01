package com.yy.springboottest01;

import com.yy.springboottest01.skill.cglib.TargetInterceptor;
import com.yy.springboottest01.skill.cglib.TargetObject;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyTest {
    @Test
    public void test01(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }
}
