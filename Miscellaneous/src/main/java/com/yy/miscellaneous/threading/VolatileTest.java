package com.yy.miscellaneous.threading;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    static volatile Object object1 = new Object();
    static Object object2=object1;
    public static void main(String[] args) throws InterruptedException {
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
        new Thread(() -> {
            Object o1=object1;
            Object o2=object2;
            while (o1==o2) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
//            System.out.println("跳出循环");

        }).start();
        Thread.sleep(3000);
        object2 = new Object();
//        System.out.println("主线程结束");

    }
}

//package com.yy.miscellaneous.threading;
//public class VolatileTest {
//    private static int num=0;
//
//    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            while(num==0){
//
//            }
//            System.out.println("跳出循环");
//        }).start();
//        Thread.sleep(3000);
//        num=1;
//        System.out.println(num);
//    }
//}


//package com.yy.miscellaneous.threading;
//
//import java.util.concurrent.TimeUnit;
//
//public class VolatileTest {
//    static volatile int num = 0;
//    static int j=num;
//    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            while (j==0) {
////                try {
////                    Thread.sleep(500);
////                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
////                }
//            }
////            System.out.println("跳出循环");
//
//        }).start();
//        Thread.sleep(3000);
//        j = 1;
////        System.out.println("主线程结束");
//
//    }
//}


//package com.yy.miscellaneous.threading;

//import java.util.concurrent.TimeUnit;
//public class VolatileTest {
//    static /*volatile*/ boolean running = true;
//
//    public static void main(String[] args) {
//        new Thread("ObserveThread") {
//            @Override
//            public void run() {
//                System.out.println("thread start");
//                while (running) {
//                }
//                System.out.println("thread end");
//            }
//        }.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        running = false;
//        System.out.println("main thread end, running = " + running);
//    }
//}