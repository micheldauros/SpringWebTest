package com.yy.miscellaneous.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class UnparkTest {


    public static void main(String[] args) {
        Runnable r=()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"正在输出");
        };
        Thread t1=new Thread(r);
//        Thread t2=new Thread(r);

        t1.start();
//        t2.start();

        LockSupport.unpark(t1);


        new Thread(()->{
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.interrupted());
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("第一次park");
            LockSupport.park();
            System.out.println(Thread.currentThread().isInterrupted());

            System.out.println("第二次park");

        }).start();

    }
}
