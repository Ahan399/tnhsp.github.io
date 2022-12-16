package com.bjpowernode.javase.reflect;

import java.util.Date;

public class ReflectTest01 {
    public static void main(String[] args) {
        /*
        Class.forname 是一个静态方法
                1.静态方法
                2.方法的参数是一个字符串
                3.字符串需要一个完整的类名
                4.完整类名必须带有包名
         */
            Class c1 = null;
            Class c2 = null;
        try {

            c1 = Class.forName("java.lang.String");//c1代表String
            c2 = Class.forName("java.util.Date");//Date类型
            Class c3 = Class.forName("java.lang.Integer");//Integer类型
            Class c4 = Class.forName("java.lang.System");//System类型

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //java中任何对象都有一个方法：getClass()
        String s = "abc";
        Class x = s.getClass(); //x 代表String.class字节码文件，s代表String类型
        System.out.println(c1 == x);//true

        Date time = new Date();
        Class y = time.getClass();
        System.out.println(c2 == y);//ture

        //第三种方式
        Class z = String.class;
        System.out.println(c1 == z);
    }
}
