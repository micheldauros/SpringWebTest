package com.yy.springboottest01;

import com.yy.springboottest01.pojo.Actor;
import com.yy.springboottest01.pojo.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;

@SpringBootTest
class SpringbootTest01ApplicationTests implements Serializable {
    private final static long serialVersionUID=1L;
    @Autowired
    public Actor actor;
    @Autowired
    public Agent agent;

////    @Autowired
//    private void inject( Actor actor){
//        System.out.println("inject is successfull\n"+actor);
//        this.actor=actor;
//    }
    @Test
    void contextLoads() {
        System.out.println(actor);
    }

    @Test
    void test01(){
        System.out.println(agent);
    }

}
