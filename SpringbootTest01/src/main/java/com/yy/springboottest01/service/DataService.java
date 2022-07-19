package com.yy.springboottest01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void JdbcService01(){
        System.out.println(jdbcTemplate);
    }
}
