package com.bjpowernode.javase.exception;

public class ExceptionTest08 {
    public static void main(String[] args) {
        NullPointerException e = new NullPointerException("空指针异常");
        String msg = e.getMessage();
        System.out.println(msg);
        e.printStackTrace();

        System.out.println("hello world!");
    }
}
