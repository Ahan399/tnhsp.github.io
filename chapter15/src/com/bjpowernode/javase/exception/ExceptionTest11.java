package com.bjpowernode.javase.exception;

public class ExceptionTest11 {
    public static void main(String[] args) {
        try{
            System.out.println("try...");
            return;
        }finally {
            System.out.println("finally..");
        }

    }
}
