package com.yy.stock.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @RequestMapping("/deposit/{id}")
    public String deposit(@PathVariable int id){

        return "hello order"+id;
    }
}
