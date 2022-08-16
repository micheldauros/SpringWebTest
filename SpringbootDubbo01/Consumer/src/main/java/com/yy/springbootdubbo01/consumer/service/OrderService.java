package com.yy.springbootdubbo01.consumer.service;

import com.yy.springbootdubbo01.interface01.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
//    @Resource
//    private RestTemplate restTemplate;

    @DubboReference
    private UserService userService;

    public String getOrder() {
//        String object = restTemplate.getForObject("http://127.0.0.1:8082/user", String.class);
        return userService.getUser();

    }
}
