package com.yy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RestControllers {
    @RequestMapping("/Rest01/{a}/{b}")
    public String rest01(@PathVariable("a") String a, @PathVariable("b") String  b, Model model){
        String  res=a+b;
        model.addAttribute("msg",res);
        System.out.println("Rest01 is accessed "+res);
        return "link03";
    }
    @RequestMapping("/Rest02/{a}/{b")
    @ResponseBody
    public String rest02(@PathVariable("a") String a, @PathVariable("b") String  b){
        return null;
    }

    @RequestMapping("/favicon.ico")
    public String getFavicon(){
        return "redirect:/favicon.ico";
    }

}
