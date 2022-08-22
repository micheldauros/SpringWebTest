package com.yy.miscellaneous;

import com.yy.miscellaneous.service.HelloTimer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

//@SpringBootTest
public class AOPTest {
    @Resource
    private HelloTimer helloTimer;
    @Test
    public void hello(){
        helloTimer.sayHello();
    }
}
