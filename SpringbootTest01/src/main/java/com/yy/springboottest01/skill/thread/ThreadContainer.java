package com.yy.springboottest01.skill.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadContainer {

    private ReentrantLock reentrantLock=new ReentrantLock();
    private Condition condition1=reentrantLock.newCondition();
    private Condition condition2=reentrantLock.newCondition();
    private int m=1;

    public void method01()  {
        reentrantLock.lock();
        try {
while(m!=1) {condition1.await();}
            m=2;
            condition2.signal();
            System.out.println("进入线程01");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            reentrantLock.unlock();
        }
    }
    public void method02() {
        reentrantLock.lock();
        try {
            while(m==1)
            {condition2.await();}
            m=1;
            condition1.signal();
            System.out.println("进入线程02");

           }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            reentrantLock.unlock();
        }
    }

}
