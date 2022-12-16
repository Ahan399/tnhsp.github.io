package com.bjpowernode.javase.reflect;

public class MyClass {
    //静态代码块在类加载的时候执行，而且只执行一次
    static {
        System.out.println("MyClass类的静态代码块执行了！");
    }
}
