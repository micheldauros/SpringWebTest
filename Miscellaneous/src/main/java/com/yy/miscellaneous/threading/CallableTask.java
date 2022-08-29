package com.yy.miscellaneous.threading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CallableTask {
    public static int k = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger i = new AtomicInteger(10);
        Callable<AtomicInteger> c1 = () -> {
            System.out.println("剩余" + i);
            ReentrantLock lock = new ReentrantLock();
            lock.notify();
            i.getAndDecrement();
            return i;
        };
        Callable<AtomicInteger> c2 = () -> {
            System.out.println("剩余" + i);
            i.getAndDecrement();
            return i;
        };
        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
                p();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

//        FutureTask<AtomicInteger> f = new FutureTask<>(c1);
//        new Thread(f).start();
//        System.out.println(f.get());
        ExecutorService es = Executors.newCachedThreadPool();
        Future<AtomicInteger> integerFuture = es.submit(c1);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("剩余" + i);

                i.getAndDecrement();
            }
        });
        for (int j = 0; j < 20; j++) {
            es.submit(new Thread(runnable, (String) ("线程" + j)));
        }
        thread.setDaemon(true);
        es.submit(thread);
        es.shutdown();
        System.out.println(integerFuture.get());


    }

    public static synchronized void p() {
        k++;
        System.out.println( "是当前线程" + k);
    }
}
