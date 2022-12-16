package com.bjpowernode.javase.annotation5;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception{

        //获取这个类，这个类里面是有注解的
        Class c = Class.forName("com.bjpowernode.javase.annotation5.MyAnnotationTest");
        //判断这个类是否有MyAnnotation
        System.out.println(c.isAnnotationPresent(MyAnnotation.class));//true
        if(c.isAnnotationPresent(MyAnnotation.class)){
            //获取该对象注解对象
            MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
            System.out.println("类上面的注解对象："+myAnnotation);
            //获取注解对象的属性？跟调接口每区别
            myAnnotation.value();
        }

    }
}
