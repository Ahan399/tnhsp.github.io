package com.bjpowernode.javase.annotation3;

public class MyAnnotationTest {
    @MyAnnotation(value = "hehe")
    public void doSome(){

    }
    @MyAnnotation("haha")
    public void doOther(){

    }
}
