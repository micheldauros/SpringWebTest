package com.yy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock", path = "/")
public interface StockFeign {
    @RequestMapping("/deposit/{id}")
    String deposit(@PathVariable("id") int id);
}
