package com.yy.miscellaneous.timer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Aspect
@Service
public class TimerAdvice {
    private LocalDateTime before;
    private LocalDateTime after;
    @Pointcut("execution(* com.yy.miscellaneous.service.HelloTimer.sayHello())")
    public void hello(){

    }
    @Before("hello()")
    public void timerStart() {
        this.before = LocalDateTime.now();
        System.out.println(before);
    }
    @After("hello()")
    public void timerStop() {
        this.after = LocalDateTime.now();
        System.out.println(after);
        System.out.println("费时：" + (this.after.getNano() - this.before.getNano()));
    }
}
