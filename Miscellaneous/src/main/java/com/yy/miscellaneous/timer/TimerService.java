package com.yy.miscellaneous.timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class TimerService {

    private LocalDateTime before;
    private LocalDateTime after;

    @Pointcut("@annotation(com.yy.miscellaneous.timer.TimerAspect))")
    public void hello() {

    }

//    @Before("hello()")
    public void timerStart() {
        this.before = LocalDateTime.now();
        System.out.println(before);
    }

//    @After("hello()")
    public void timerStop() {
        this.after = LocalDateTime.now();
        System.out.println(after);
        System.out.println("费时：" + (this.after.getNano() - this.before.getNano()));
    }

    @Around("hello()")
    public void timer(ProceedingJoinPoint joinPoint) throws Throwable {
        int s=LocalDateTime.now().getNano();
        joinPoint.proceed();
        int e=LocalDateTime.now().getNano();
        System.out.println("耗时："+(e-s));
    }
}
