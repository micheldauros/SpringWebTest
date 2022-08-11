package com.yy.springsecurity02.controller;

import com.yy.springsecurity02.bean.UserBean;
import com.yy.springsecurity02.util.MyConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/mobile")
public class MobileController {
    @GetMapping("/query")
    public String query(HttpSession session){
        if(session.getAttribute(MyConstants.FLAG_CURRENTUSER) != null){
            return "mobile";
        }else
            return "fail";
    }
}
