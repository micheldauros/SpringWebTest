package com.yy.miscellaneous.threading;

import java.util.concurrent.TimeUnit;

public class Singleton {
   private static  Singleton singleton;
   private Singleton() throws InterruptedException {
//       TimeUnit.MILLISECONDS.sleep(100);
       System.out.println(Thread.currentThread().getName()+"OK");
   }
   public static Singleton getInstance() throws InterruptedException {
       if (singleton == null) {
           synchronized (Singleton.class) {
               if (singleton == null) {
                   //防止指令重排
                   singleton = new Singleton();
               }
           }
       }
       return singleton;
   }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    Singleton.getInstance();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}