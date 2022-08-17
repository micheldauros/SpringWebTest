package com.yy.springbootdubbo01.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
//    public static void main(String[] args) {
//        new EmbeddedZooKeeper(2181, false).start();
//        SpringApplication.run(ProviderApplication.class, args);
//        System.out.println("dubbo service started");
//    }

}
