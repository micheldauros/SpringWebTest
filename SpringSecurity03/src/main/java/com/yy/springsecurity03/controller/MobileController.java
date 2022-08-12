package com.yy.springsecurity03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/mobile")
public class MobileController {
    @GetMapping("/query")
    public String query(HttpSession session){
        return "mobile";
    }
}
