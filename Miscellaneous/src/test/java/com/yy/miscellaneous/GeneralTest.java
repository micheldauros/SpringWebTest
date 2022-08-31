package com.yy.miscellaneous;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class GeneralTest {
    @Test
    public void stopWatch01() {
        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(3000);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));
    }
    @Test
    public void digest01(){
        for (int i = 0; i < 10; i++) {
            byte[] b = DigestUtils.md5Digest("hello world".getBytes());
            byte[] d = DigestUtils.md5Digest("hello world".getBytes());

            String c=Arrays.toString(b);
            System.out.println(b);//每次结果都不一样，为什么？
            System.out.println(c);
            System.out.println(d);
        }
    }

    @Test
    public void bitTest(){
        for (int j = -1; j < 4; j++) {
            System.out.println((Integer.toBinaryString(j<<29)));
        }

    }

    @Test
    public void breakTest(){
        a:{
            System.out.println("0");
            b:{
                System.out.println("1");
                c:{
                    System.out.println("2");
                    if(1==1)
                        break a;
                }
                System.out.println("3");
            }
            System.out.println("4");
        }
        System.out.println("5");
    }

}
