package com.bjpowernode.javase.annotation2;


public class MyAnnotationTest {

    //如果一个注解当中有属性，必须给属性赋值
    /*@MyAnnotation
    public void doSome(){

    }*/
    @MyAnnotation(name="zhangsan",color = "红色")
    public void doSome(){

    }
    public static void main(String[] args) {

    }
}
