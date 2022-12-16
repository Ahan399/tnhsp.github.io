package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest09 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
            //在实际开发中建议使用这个打印堆栈异常追踪信息
            /*
            at com.bjpowernode.javase.exception.ExceptionTest09.m3(ExceptionTest09.java:26)
	at com.bjpowernode.javase.exception.ExceptionTest09.m2(ExceptionTest09.java:22)
	at com.bjpowernode.javase.exception.ExceptionTest09.m1(ExceptionTest09.java:18)
	at com.bjpowernode.javase.exception.ExceptionTest09.main(ExceptionTest09.java:9)
             */
            e.printStackTrace();
        }
        System.out.println("已捕捉到异常");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {
        new FileInputStream("D:\\baiduDown");
    }
}
