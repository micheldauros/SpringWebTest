package com.yy.miscellaneous.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadCore {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor es=new ThreadPoolExecutor(1,5,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3));
        for (int i = 1; i < 7; i++) {
            final int count=i;
            TimeUnit.MILLISECONDS.sleep(100);
            es.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"正在运行"+count);
            });
        }

//        es.shutdown();
    }
}
