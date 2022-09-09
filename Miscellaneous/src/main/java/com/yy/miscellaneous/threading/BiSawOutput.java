package com.yy.miscellaneous.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BiSawOutput {
    static volatile boolean flag=false;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 26; i++) {
                try {
                    while (!flag) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i+1);
                flag=false;
                condition.signalAll();
            }
            lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 26; i++) {
                try {
                    while (flag) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println((char) (65 + i));
                flag=true;
                condition.signalAll();

            }
            lock.unlock();
        }).start();
    }
}
