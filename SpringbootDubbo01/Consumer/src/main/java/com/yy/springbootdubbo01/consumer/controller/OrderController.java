package com.yy.springbootdubbo01.consumer.controller;

import com.yy.springbootdubbo01.consumer.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order")
    public String getOrder() {
        return orderService.getOrder();
    }
}
