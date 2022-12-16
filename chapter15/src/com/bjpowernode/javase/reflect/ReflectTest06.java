package com.bjpowernode.javase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
通过反编译机制，反编译一个field
 */
public class ReflectTest06 {
    public static void main(String[] args) throws Exception{
        //创建这个是为了拼接字符串
        StringBuilder s = new StringBuilder();

        Class studentClass = Class.forName("java.util.Date");

        s.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName()+ "{\n");

        Field[] fields = studentClass.getDeclaredFields();
        for (Field field:fields ) {
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
