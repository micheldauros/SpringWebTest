package com.yy.order.controller;

import com.yy.order.feign.StockFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@EnableDiscoveryClient
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private StockFeign stockFeign;
    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功");
//        return restTemplate.getForObject("http://stock/deposit/",String.class);
        return stockFeign.deposit(10);

    }
}
