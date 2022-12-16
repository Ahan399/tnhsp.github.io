package com.bjpowernode.javase.exception;

public class ExceptionTest04 {
    public static void main(String[] args) {
        //main方法中调用doSome()方法
        //因为doSome()抛出了ClassNotFoundException
        //我们必须在调用doSome时对这种异常做出处理，不处理编译器就会报错
        try {
            doSome();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
    代码表示doSome方法在执行过程中可能出现ClassNotFoundException
    类没找到异常。这个异常直接父类是Exception
     */
    public static void doSome() throws ClassNotFoundException{
        System.out.println("执行了");
    }
}
