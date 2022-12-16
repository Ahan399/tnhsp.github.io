package com.bjpowernode.javase.integer;
/*
关于Integer类的构造方法有两种：
Integer(int)
Integer(String)
 */
public class IntegerTest03 {
    public static void main(String[] args) {
        //将数字100转换为Integer数据类型
        Integer x =new Integer(100);
        //将String类的数字转换为Integer数据类型
        Integer y =new Integer("123");
        System.out.println(x);
        System.out.println(y);

        Double e = new Double(1.23);
        Double z = new Double("1.23");

        System.out.println("int最大值:"+ Integer.MAX_VALUE);
        System.out.println("int最小值:"+ Integer.MIN_VALUE);


    }
}
