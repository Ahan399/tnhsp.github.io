package com.bjpowernode.javase.reflect;

import java.lang.reflect.Method;

/*
使用反射机制调用一个对象的方法（重点）非常重要，必须死记硬背！
 */
public class ReflectTest10 {
    public static void main(String[] args) throws Exception{

        Class userServiceClass = Class.forName("com.bjpowernode.javase.service.UserService");
        Object obj = userServiceClass.newInstance();
        //获取Method
        //靠方法名和形参区分方法,找到改方法
        Method loginMethod = userServiceClass.getDeclaredMethod("login", String.class, String.class);
        //调用方法
        //要素1 对象 ，要素2 login方法，要素3 实参列表，要素4 返回值
        //这个方法发生了调用，调用了这个obj对象,参数是"admin"和"123"
        Object getValue = loginMethod.invoke(obj,"admin","123");
        System.out.println(getValue);//true
    }
}
