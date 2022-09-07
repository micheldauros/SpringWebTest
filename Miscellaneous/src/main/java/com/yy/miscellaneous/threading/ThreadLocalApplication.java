package com.yy.miscellaneous.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalApplication {
    public static AtomicInteger counter=new AtomicInteger(0);
    public static ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        
        ExecutorService exec = Executors.newFixedThreadPool(99);
        for (int i = 0; i < 1000; i++) {
            exec.execute(() -> {
                threadLocal.set(new byte[1024 * 1024]);
                try {
                    System.out.println(counter.incrementAndGet());
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    threadLocal.remove();
                }
            });
        }
        TimeUnit.SECONDS.sleep(10);
        exec.shutdown();
    }
}
