package com.bjpowernode.javase.exception;

public class ExceptionTest14 {
    public static void main(String[] args) {
        //关键字，表示最终的，不可变的
        final int i =100;
        //finally是一个关键字，和try联合使用的
        try {

        } finally {
            System.out.println("finally...");
        }

        //finalize()是Object的一个方法
        Object obj;
    }
}
