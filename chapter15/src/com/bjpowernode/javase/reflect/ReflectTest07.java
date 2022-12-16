package com.bjpowernode.javase.reflect;

import java.lang.reflect.Field;

/*
必须掌握：

    怎么通过一个访问机制，访问一个java对象的属性？
        给属性赋值
        获取属性的值


 */
public class ReflectTest07 {
    public static void main(String[] args) throws Exception{

        //使用反射机制，怎么去访问一个对象的属性值
        Class studentClass = Class.forName("com.bjpowernode.javase.bean3.Student");
        Object obj = studentClass.newInstance();

        //获取no的属性（根据属性的名称获取field）
        Field noFiled = studentClass.getDeclaredField("no");
        //给OBJ对象的（String对象） 的no属性赋值
        //方法顺序比较诡异，但依然满足三要素，为obj的noFiled属性赋值为2222
        noFiled.set(obj,2222);//给obj对象的no属性赋值2222

        //满足两要素
        System.out.println(noFiled.get(obj));//获取obj对象的noFiled属性的值

        //可以访问私有实现吗？
        //获取name属性
        Field nameField = studentClass.getDeclaredField("name");
        //打破封装（反射机制的缺点，打破封装）
        //这样设置完后，在外面也可以访问private的
        nameField.setAccessible(true);

        nameField.set(obj,"jackson");
        System.out.println(nameField.get(obj));//无法反问，因为是私有属性


    }
}
