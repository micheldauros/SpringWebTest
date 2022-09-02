package com.yy.miscellaneous;

import com.google.common.base.Stopwatch;
import com.yy.miscellaneous.threading.Singleton;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.function.Function;

public class GeneralTest {
    @Test
    public void stopWatch01() {
        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(3000);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));
    }

    @Test
    public void digest01() {
        for (int i = 0; i < 10; i++) {
            byte[] b = DigestUtils.md5Digest("hello world".getBytes());
            byte[] d = DigestUtils.md5Digest("hello world".getBytes());

            String c = Arrays.toString(b);
            System.out.println(b);//每次结果都不一样，为什么？
            System.out.println(c);
            System.out.println(d);
        }
    }

    @Test
    public void bitTest() {
        for (int j = -1; j < 4; j++) {
            System.out.println((Integer.toBinaryString(j << 29)));
        }

    }

    @Test
    public void breakTest() {
        a:
        {
            System.out.println("0");
            b:
            {
                System.out.println("1");
                c:
                {
                    System.out.println("2");
                    if (1 == 1)
                        break a;
                }
                System.out.println("3");
            }
            System.out.println("4");
        }
        System.out.println("5");
    }

    @Test
    public void functionTest() {
        Function<String, String> function = str -> str;
        System.out.println(function.apply(String.valueOf(10)));
        Function<String, String> function1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };
    }

    @Test
    public void completableFutureTest() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3) {
        });
        CompletableFuture<Integer> f = new CompletableFuture<>();
        executor.execute(() -> {
            int n = 0;
        });
    }

    static class TestNumber {
        public static AtomicInteger number = new AtomicInteger();

        public static void add() {
            number.getAndIncrement();
        }
    }

    @Test
    public void volatileTest() {

        for (int j = 0; j < 20; j++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    TestNumber.add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
        }
        System.out.println(TestNumber.number.get());
    }

    @Test
    public void singletonTest() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Singleton.getInstance();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }
        while (Thread.activeCount() > 2) {

        }
    }

    @Test
    public void atomicIntegerTest() {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1000, 1);
        System.out.println(atomicStampedReference.hashCode());
        System.out.println(atomicStampedReference.compareAndSet(1000, 1001, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
        System.out.println(atomicStampedReference.hashCode());
        System.out.println(atomicStampedReference.getReference());
    }

    @Test
    public void CASTest() {
        AtomicInteger integer = new AtomicInteger(1);
        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println(integer.getAndIncrement());
                }

//            System.out.println(integer.get());

            }).start();
        }


        while (Thread.activeCount() > 2) {

        }
        System.out.println(integer.get());
    }
}
