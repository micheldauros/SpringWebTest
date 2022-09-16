package com.yy.miscellaneous.threading;

import java.util.concurrent.TimeUnit;

public class VolatileThread extends Thread {
    private int k;

    @Override
    public void run() {
        while(k==10){
            System.out.println("循环进行中");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("跳出循环");
    }

    public void setK(int k) {
        this.k = k;
    }

    public VolatileThread(int k) {
        this.k = k;
    }
}
