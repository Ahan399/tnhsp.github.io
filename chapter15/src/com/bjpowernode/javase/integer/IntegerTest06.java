package com.bjpowernode.javase.integer;

public class IntegerTest06 {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);//false

        /*
        java中为了提供程序的执行效率，将【-128，127】之间的包装对象提取创建好
        放到了一个方法区的"整数型常量池"中，目的是让它不用在new了
         */
        Integer x =127;
        Integer y =127;
        System.out.println(x == y);//true
    }
}
