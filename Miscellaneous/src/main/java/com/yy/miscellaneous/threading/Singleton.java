package com.yy.miscellaneous.threading;

import java.util.concurrent.TimeUnit;

public class Singleton {
    private int i;

    private int method01() {

        return 1;
    }

    private static Singleton singleton;

    private Singleton() throws InterruptedException {
        this.i = method01();
        System.out.println(Thread.currentThread().getName() + " OK "+this.i);
    }

    public static Singleton getInstance() throws InterruptedException {
        if (singleton == null) {
            System.out.println(Thread.currentThread().getName() + "进入第一层判定");
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
//                    TimeUnit.MILLISECONDS.sleep(10);
                    Singleton instance = Singleton.getInstance();
                    System.out.println(instance.i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }
}