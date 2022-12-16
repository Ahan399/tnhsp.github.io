package com.bjpowernode.javase.reflect;

import java.lang.module.ModuleFinder;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest05 {
    public static void main(String[] args) throws Exception{
        //获取整个类
        Class studentClass = Class.forName("com.bjpowernode.javase.bean3.Student");
        String classname = studentClass.getName();
        System.out.println("完整类名："+classname);
        String simpleName = studentClass.getSimpleName();
        System.out.println("简类名："+simpleName);

        //获取类中的所有public属性Field
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length);//1,测试数组中只有一个元素
        //取出这个Field
        Field f = fields[0];
        System.out.println(f.getName());//no

        //获取所有的Field
        Field[] fs = studentClass.getDeclaredFields();
        System.out.println(fs.length);//5
        System.out.println("===============");
        for (Field field: fs) {
            //获取属性的名字
            String fieldName = field.getName();
            //获取属性的类型
            Class fieldType = field.getType();//获取属性类型，返回Class
            String fName = fieldType.getSimpleName();//获取简类名
            //获取属性的修饰符列表
            //返回的修饰符是一个Int,每个修饰符是一个代号
            int i = field.getModifiers();//获取一个field对象的多个修饰符，修饰符可能是多个
            //可以将一个字符串转换为一个数字吗,用静态方法如下
            String modifierString = Modifier.toString(i);

            System.out.println(modifierString +" "+ fName +" "+ fieldName);
        }
    }
}
