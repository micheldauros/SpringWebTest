package com.yy.miscellaneous.threading;

public class LockTest extends Thread  {
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        for (int i = 0; i < 3; i++) {
            Thread thread=new Thread(lockTest);

            System.out.println(thread.hashCode());
            thread.setName(i+"线程");
            thread.start();

        }
    }
}
