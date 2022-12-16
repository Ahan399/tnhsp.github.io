package com.bjpowernode.javase.reflect;

import java.lang.reflect.Constructor;

/*
通过反射机制调用构造方法
 */
public class ReflectTest12 {
    public static void main(String[] args) throws Exception{

        Class c = Class.forName("com.bjpowernode.javase.bean3.Vip");
        //调用无参构造方法
        Object obj = c.newInstance();
        //调用有参构造方法
        //第一步，获取这个有参数的构造方法
        //构造方法依靠形参作为区分
        Constructor con = c.getDeclaredConstructor(int.class,String.class,String.class,boolean.class);
        //第二步，调用构造方法new对象
        Object newObj = con.newInstance(110,"jackson","1990-10-11",true);
        System.out.println(newObj);

    }

}
