package com.yy.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @RequestMapping("/deposit")
    public String deposit(){
        System.out.println("订单处理中");
        return "hello order";
    }
}
