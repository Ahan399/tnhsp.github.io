package com.bjpowernode.javase.integer;

public class IntegerTest05 {
    public static void main(String[] args) {
        //自动装箱
        //基本数据类型 --（自动转换）--> 包装类型
        Integer x = 100;
        //自动拆箱
        //包装类型 --（自动转换）--> 基本数据类型
        int y =x;

        Integer z = 1000;
        //为什么没报错？？
        //+两边要求是基本数据类型的数字，z是包装类不属于基本数据类型，这里会进行自动拆箱，将z自动转换为基本数据类型
        System.out.println(z + 1);
        Integer a = 234;
        Integer b = 234;
        // == 比较的是对象的内存地址
        // == 不会触发自动触发拆箱机制，只有 + - * / 等运算才会
        System.out.println(a == b);//false,两个引用指向的对象内存地址不一样！
        System.out.println(a.equals(b));
    }
}
