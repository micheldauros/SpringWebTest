package com.yy.springsecurity02.controller;

import com.yy.springsecurity02.bean.UserBean;
import com.yy.springsecurity02.service.AuthService;
import com.yy.springsecurity02.util.MyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/common")
public class LoginController {
    @Resource
    private AuthService authService;
    @PostMapping("/login")
    public UserBean login(UserBean loginUser, HttpServletRequest request){
        UserBean user=authService.userLogin(loginUser);
        if(user!=null){
            log.info("用户登陆成功");
            request.getSession().setAttribute(MyConstants.FLAG_CURRENTUSER,user);
        }else
            log.info("用户登陆失败");
        return user;

    }


    @PostMapping("/getCurrentUser")
    public Object getCurrentUser(HttpSession session){
        return session.getAttribute(MyConstants.FLAG_CURRENTUSER);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute(MyConstants.FLAG_CURRENTUSER);
    }
}
