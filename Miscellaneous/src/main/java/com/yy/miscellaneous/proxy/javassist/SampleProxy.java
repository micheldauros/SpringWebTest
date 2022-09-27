package com.yy.miscellaneous.proxy.javassist;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import javassist.*;
import javassist.util.HotSwapper;

import java.io.IOException;

public class SampleProxy {
    public static void main(String[] args) {
        Sample01 sample01 = new Sample01();
        sample01.doSomething();
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass clazz = pool.get("com.yy.miscellaneous.proxy.javassist.Sample01");
            CtMethod cm = clazz.getDeclaredMethod("doSomething");
            cm.insertAt(1,"{System.out.println(\"hello HotSwapper.\");}");  // clazz完全可以是全新的，这里只是为了测试方便而已
            // 必须要有vm选项：-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000
            HotSwapper swap = new HotSwapper(8080);
            swap.reload("com.yy.miscellaneous.proxy.javassist.Sample01", clazz.toBytecode());
            sample01.doSomething();
        } catch (CannotCompileException | IOException | IllegalConnectorArgumentsException | NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
