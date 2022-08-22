package com.yy.miscellaneous.timer;

import org.springframework.stereotype.Component;

@Component
public class TimerImpl {
    @TimerAspect
    public void sayHello() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello timer");
    }
}
