package com.yy.springboottest01.controller;

import com.yy.springboottest01.pojo.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller

public class Controller01 {
    public Actor actor;
    @ResponseBody
    @RequestMapping("/controller01")
    public String controller01(@Validated Actor actor){
        System.out.println(actor.getLastUpdate());
        LocalDateTime dateTime=actor.getLastUpdate();
        System.out.println(dateTime.toLocalDate());
        System.out.println(actor.getLastUpdate().toLocalTime());
        System.out.println(this.actor);
        return actor.getFirstName()+actor.getLastName();
    }

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","hello-world");
        return "test";
    }
}
