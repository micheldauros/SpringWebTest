package com.yy.miscellaneous.service;

import com.mongodb.client.result.DeleteResult;
import com.yy.miscellaneous.pojo.MongoPojo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MongoService {
    @Resource
    private MongoTemplate mongoTemplate;

    public String  saveMP(MongoPojo mongoPojo){
        mongoTemplate.save(mongoPojo);
        return "success";
    }
    public List<MongoPojo> findAll() {
        return mongoTemplate.findAll(MongoPojo.class);
    }
}
