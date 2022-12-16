package com.bjpowernode.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectTest11 {
    public static void main(String[] args) throws Exception{
        StringBuilder s = new StringBuilder();
        Class vipClass = Class.forName("com.bjpowernode.javase.bean3.Vip");
        s.append(Modifier.toString(vipClass.getModifiers()));
        s.append(" class ");
        s.append(vipClass.getSimpleName());
        s.append("{\n");

        //拼接构造方法
        Constructor[] constructors = vipClass.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            s.append("\t");
            s.append(Modifier.toString(constructor.getModifiers()));
            s.append(" ");
            s.append(vipClass.getSimpleName());
            s.append("(");
            //拼接参数
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType:parameterTypes) {
                s.append(parameterType.getSimpleName());
                s.append(",");
            }
            if(parameterTypes.length>0) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append("){}\n");
        }

        s.append("\n}");
        System.out.println(s);
    }
}
