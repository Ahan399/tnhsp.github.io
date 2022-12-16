package com.bjpowernode.javase.reflect;

import java.io.FileReader;
import java.util.Properties;

/*
验证反射机制的灵活性
 */
public class ReflectTest03 {
    public static void main(String[] args) throws Exception{
        //通过io流读取classinfo.properties文件
        FileReader reader = new FileReader("classinfo.properties");
        //创建属性类对象MAP
        Properties pro = new Properties();
        //加载
        pro.load(reader);

        reader.close();
        //通过key获取value,拿到className类名
        String className = pro.getProperty("className");
        /*System.out.println(className);*/

        //通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);

    }
}
