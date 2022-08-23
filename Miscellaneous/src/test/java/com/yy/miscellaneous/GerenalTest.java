package com.yy.miscellaneous;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class GerenalTest {
    @Test
    public void stopWatch01() {
        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(3000);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));
    }
    @Test
    public void digtest01(){
        for (int i = 0; i < 10; i++) {
            byte[] b = DigestUtils.md5Digest("hello word".getBytes());
            byte[] d = DigestUtils.md5Digest("hello word".getBytes());

            String c=Arrays.toString(b);
            System.out.println(b);//每次结果都不一样，为什么？
            System.out.println(c);
            System.out.println(d);
        }
    }
}
