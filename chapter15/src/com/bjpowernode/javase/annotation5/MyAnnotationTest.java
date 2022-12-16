package com.bjpowernode.javase.annotation5;
@MyAnnotation("shanghai")
public class MyAnnotationTest {
    int i;

    public MyAnnotationTest() {
    }

    @MyAnnotation
    public void doSome(){

        int i;
    }
}
