package com.bjpowernode.javase.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
反射method

 */
public class ReflectTest08 {
    public static void main(String[] args) throws Exception{

        Class userServiceClass = Class.forName("com.bjpowernode.javase.service.UserService");

        //获取所有Method
        Method[] methods = userServiceClass.getDeclaredMethods();
        System.out.println(methods.length);//2

        //遍历Method
        for (Method method:methods) {

           //获取修饰参数列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取方法的返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            //方法参数列表里的参数们,获取参数们的类型，返回的是类型的一个数组
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType:parameterTypes) {
                System.out.println(parameterType.getSimpleName());
            }
        }

    }
}
