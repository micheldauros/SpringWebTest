package com.yy.miscellaneous.threading;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        TestResource testResource = new TestResource();
        new Thread(testResource::business1, "业务1").start();
        new Thread(testResource::business2, "业务2").start();
        new Thread(testResource::monitor, "监视器").start();


    }
}

class TestResource {
    private int resource = 1000;
    private int flag = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void business1() {
        assert lock.getHoldCount() == 0;
        lock.lock();
        try {
            for (int i = 1; i < 100; i++) {
                while (0 != flag) {
                    System.out.println("业务1等待前");

                    condition.await();
                    System.out.println("业务1等待后");

                }
                resource--;
                flag = 1;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "第" + i + "次进行业务1" + " 业务剩余" + resource);
                condition.signalAll();
                System.out.println("业务1释放条件");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void business2() {
        assert lock.getHoldCount() == 0;
        lock.lock();
        try {
            for (int i = 1; i < 100; i++) {
                while (1 != flag) {
                    System.out.println("业务2等待前");
                    condition.await();
                    System.out.println("业务2等待后");
                }
                resource--;
                flag = 0;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "第" + i + "次进行业务2" + " 业务剩余" + resource);
                condition.signalAll();
                System.out.println("业务2释放条件");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void monitor() {
        try {
            for (int i = 0; i < 1; i++) {
                assert !lock.isHeldByCurrentThread();
                lock.lock();
                TimeUnit.MILLISECONDS.sleep(5000);
                System.out.println("当前等待锁的线程有" + lock.getQueueLength() + "个");
                System.out.println("当前等待条件的线程有" + lock.getWaitQueueLength(condition) + "个");
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}