package com.bjpowernode.javase.reflect;
/*
研究一下：Class.forName()发生了什么？
 */
public class ReflectTest04 {
    public static void main(String[] args) {
        try {
            //这个方法的执行会导致类加载，静态代码块就必然会执行！
             Class.forName("com.bjpowernode.javase.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
