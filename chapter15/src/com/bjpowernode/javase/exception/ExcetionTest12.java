package com.bjpowernode.javase.exception;

public class ExcetionTest12 {
    public static void main(String[] args) {
        try{
            System.out.println("try...");
            System.exit(0);
        }finally {
            System.out.println("finally..");
        }

    }
}
