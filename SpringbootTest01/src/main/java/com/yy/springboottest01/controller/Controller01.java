package com.yy.springboottest01.controller;

import com.yy.springboottest01.pojo.Actor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller01 {
    @RequestMapping("/controller01")
    public String controller01(@Validated Actor actor){
        System.out.println(actor.getLastUpdate());
        LocalDateTime dateTime=actor.getLastUpdate();
        System.out.println(dateTime.toLocalDate());
        return actor.getFirstName()+actor.getLastName();
    }
}
