package com.bjpowernode.javase.exception;

public class ExceptionTest03 {
    public static void main(String[] args) {
        /*
        程序执行到此处发生了ArithmeticException异常
        底层new了一个ArithmeticException异常对象
        然后抛出了，由于是main方法调用了100/0，所以这个异常抛给了main
        main方法没有处理，所以将这个异常抛给了JVM
         */
        System.out.println(100 / 0);
        System.out.println("Hello World!");
    }
}
