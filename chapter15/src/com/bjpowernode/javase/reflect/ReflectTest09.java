package com.bjpowernode.javase.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest09 {
    public static void main(String[] args) throws Exception{

        StringBuilder s = new StringBuilder();
        Class userServiceClass = Class.forName("com.bjpowernode.javase.service.UserService");

        s.append(Modifier.toString(userServiceClass.getModifiers())+" class "+userServiceClass.getSimpleName()+"\n{");

        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method:methods) {
            s.append("\n");
            s.append("\t");
            s.append(Modifier.toString(method.getModifiers()));
            s.append(" ");
            s.append(method.getReturnType().getSimpleName());
            s.append(" ");
            s.append(method.getName());
            s.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType:parameterTypes){
                    s.append(parameterType.getSimpleName());
                    s.append(",");
            }
            //删除指定下标位置上的字符，正好删除最后一个参数后面多出的,
            s.deleteCharAt(s.length()-1);
            s.append(")");
            s.append("{}");
        }
        s.append("\n}");
        System.out.println(s);
    }
}
