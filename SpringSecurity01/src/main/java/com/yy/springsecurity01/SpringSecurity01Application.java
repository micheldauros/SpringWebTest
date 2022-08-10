package com.yy.springsecurity01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringSecurity01Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext a = SpringApplication.run(SpringSecurity01Application.class, args);
        System.out.println(a);
    }

}
