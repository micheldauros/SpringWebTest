package com.yy.springboottest02.controller;

import com.yy.springboottest02.pojo.User1;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/haha")
    public User1 haha(){
        User1 user1=new User1();
        user1.setAge(10);
        user1.setName("Tom");
        user1.setLastUpdate(LocalDateTime.now());
        user1.setArrivalDates(new LocalDate[]{LocalDate.of(2001,12,22),LocalDate.of(2021,1,2)});
        return user1;
    }
}
