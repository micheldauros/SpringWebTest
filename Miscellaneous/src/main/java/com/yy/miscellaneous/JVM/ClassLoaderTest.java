package com.yy.miscellaneous.JVM;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

public class ClassLoaderTest {
    public static void main(String[] args) {
        Arrays.stream(Launcher.getBootstrapClassPath().getURLs()).forEach(System.out::println);
        System.out.println(Launcher.getLauncher().getClassLoader());
        System.out.println(Launcher.getLauncher().getClassLoader().getParent());
        System.out.println(Launcher.getLauncher().getClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

    }
}
