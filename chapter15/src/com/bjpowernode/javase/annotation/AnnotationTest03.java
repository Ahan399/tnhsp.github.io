package com.bjpowernode.javase.annotation;
/*
@Deprecated 表示这个类已过时
 */
public class AnnotationTest03 {
    public static void main(String[] args) {
        AnnotationTest03.doSome();
    }
    @Deprecated
    public static void doSome(){

        System.out.println("do something");
    }
    public static void  doOther(){
        System.out.println("do other....");
    }
}
