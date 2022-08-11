package com.yy.springsecurity02.service;

import com.yy.springsecurity02.bean.UserBean;
import com.yy.springsecurity02.util.TestData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class AuthService {
    private final String demoUsername="admin";
    private final String demoPassword="admin";
    @Resource
    private TestData testData;
    public UserBean userLogin(UserBean user){
        UserBean queryUser=testData.queryUser(user);
        if(queryUser!=null){
            queryUser.setUserId(UUID.randomUUID().toString());
        }
        return queryUser;
    }
}
