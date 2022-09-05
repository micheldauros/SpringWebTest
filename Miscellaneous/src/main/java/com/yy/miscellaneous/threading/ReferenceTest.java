package com.yy.miscellaneous.threading;

public class ReferenceTest {
    public SubClass sc;
    public ReferenceTest(SubClass sc){
        this.sc=sc;
    }


    public static void main(String[] args) {
        SubClass sc=new SubClass();
        ReferenceTest rt=new ReferenceTest(sc);
        sc=null;


    }
}
