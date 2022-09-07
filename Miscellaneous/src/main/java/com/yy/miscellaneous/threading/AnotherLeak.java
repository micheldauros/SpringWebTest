package com.yy.miscellaneous.threading;

public class AnotherLeak {
    public static void main(String[] args) {
        B b=new B(10);
        A a=new A(b);
        System.out.println(A.b.data);
        b=null;
        System.out.println(A.b.data);
        a=null;
        A aa=new A();
        System.out.println(aa.b.data);
    }
}
class A{
    public static B b;
    public int c=0;
    public A(){}
    public A(B bb){
        b=bb;
    }
}
class B{
    public int data;
    public B(int data){
        this.data=data;
    }
}