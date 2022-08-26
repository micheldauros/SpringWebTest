package com.yy.miscellaneous.controller;

import com.yy.miscellaneous.pojo.MongoPojo;
import com.yy.miscellaneous.service.MongoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MongoController {
    @Resource
    private MongoService mongoService;
    @RequestMapping("/mongoadd")
    public String madd(){
        mongoService.saveMP(new MongoPojo(3, "jerry", 3));
        return mongoService.saveMP(new MongoPojo(2, "tom", 29));
    }

    @RequestMapping("/mongoall")
    public List<MongoPojo> mall(){
        return mongoService.findAll();
    }
}
