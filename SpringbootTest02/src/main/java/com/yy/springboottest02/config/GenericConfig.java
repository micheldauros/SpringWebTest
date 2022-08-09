package com.yy.springboottest02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
public class GenericConfig <T>{
    @Bean
    public LinkedList<T> linkList(){
        return new LinkedList<T>();
    }
}
