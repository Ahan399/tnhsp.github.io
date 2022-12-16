package com.bjpowernode.javase.integer;
/*
    8种包装类型分别是什么？
 */
public class IntegerTest02 {
    public static void main(String[] args) {
        // 123这个基本数据类型，进行构造方法包装达到了：基本数据类型向引用数据类型的转换
        // 基本数据类型 --》 引用数据类型 （装箱）
        Integer i = new Integer(123);
        //将引用数据类型 --》 基本数据类型 （拆箱）
        float f = i.floatValue();
        System.out.println(f);//123.0
    }
}
