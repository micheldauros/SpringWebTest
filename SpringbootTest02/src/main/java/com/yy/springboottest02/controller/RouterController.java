package com.yy.springboottest02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/success")
    public String success(){
        return "views/success";
    }
    @RequestMapping("/{level}/{id}")
    public String level(@PathVariable("level") String level,@PathVariable("id") int id){
        return "views/"+level+"/"+id;
    }
    @RequestMapping("/logincheck")
    public String loginCheck(@RequestParam("username") String userName, @RequestParam("password") String password, HttpServletRequest request){
        if (userName.equals("张三")&&password.equals("123456")){
            request.getSession().setAttribute("user","张三");
            return "redirect:/success";
        }
        else
            return "views/error";
    }
}
