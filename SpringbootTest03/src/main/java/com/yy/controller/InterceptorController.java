package com.yy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class InterceptorController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            session.setAttribute("name", "Tom");
        } else {
            return "session already added";
        }
        return "session is successfully added";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("name") != null) {
            session.removeAttribute("name");
        } else {
            return "session not available";
        }
        return "session is successfully removed";
    }

}
