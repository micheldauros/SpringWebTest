package com.yy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
    @RequestMapping(value = "/controller01")
    public String controller01(){
        System.out.println("controller 01 is accessed");
        return "ajax/hello";
    }
}
