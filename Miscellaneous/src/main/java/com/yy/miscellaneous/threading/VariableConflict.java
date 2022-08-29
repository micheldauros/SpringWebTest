package com.yy.miscellaneous.threading;

public class VariableConflict implements Runnable {
    private int total = 10;

    public void run() {
        while (total > 0) {
            //                Thread.sleep(100);
            System.out.println("当前线程："+Thread.currentThread().getName()+"剩余" + total + "张票");
            total--;
        }
    }

    public static void main(String[] args) {
        VariableConflict variableConflict = new VariableConflict();

        new Thread(variableConflict,"thread1").start();
        new Thread(variableConflict,"thread2").start();
        new Thread(variableConflict,"thread3").start();

    }
}
