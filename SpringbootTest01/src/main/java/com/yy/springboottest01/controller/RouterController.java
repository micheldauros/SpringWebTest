package com.yy.springboottest01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return  "views/login";
    }
    @RequestMapping("/level{level}/{id}")
    public String level(@PathVariable("level") int level,@PathVariable("id") int id){
        return "views/level"+level+"/"+id;
    }
}
