package com.yy.springboottest01;

import com.yy.springboottest01.pojo.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTest01ApplicationTests {
    @Autowired
    private static Actor actor;
    @Test
    void contextLoads() {
        System.out.println(actor);
    }

}
