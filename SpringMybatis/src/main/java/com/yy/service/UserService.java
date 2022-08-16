package com.yy.service;

import com.yy.mapper.UserMapperImpl;
import com.yy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapperImpl userMapperImpl;
//    @Transactional
    public void Operation01() {
        User user=new User();
        user.setName("Tommy");
        user.setId(10);
        user.setPassword("87654321");
        userMapperImpl.addUser(user);
        throw new NullPointerException();
    }
}
