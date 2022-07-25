package com.yy.springboottest01.skill.thread;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadContainer threadContainer=new ThreadContainer();
        new Thread(threadContainer::method01,"thread01").start();
        new Thread(threadContainer::method02,"thread02").start();
    }
}
