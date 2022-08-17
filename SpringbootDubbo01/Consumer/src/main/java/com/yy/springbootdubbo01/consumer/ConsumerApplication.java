package com.yy.springbootdubbo01.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Service
@EnableDubbo
@SpringBootApplication
public class ConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
//    @DubboReference
//    private DemoService demoService;
//
//    public static void main(String[] args) {
//
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsumerApplication.class, args);
//        ConsumerApplication application=applicationContext.getBean(ConsumerApplication.class);
//        String result = application.doSayHello("world");
//        System.out.println("result: "+result);
//    }
//
//    public String doSayHello(String name) {
//        return demoService.sayHello(name);
//    }

}
