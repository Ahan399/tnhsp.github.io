package com.bjpowernode.javase.collection;

import java.util.Properties;

/*
目前只需要掌握Properties属性类对象的相关方法即可
    Properties是一个map集合，继承Hashtable线程安全,key和value都是String类

    setProperty() 向集合添加键值对
    getProperty() 根据key获取value
 */
public class ProperTiesTest01 {
    public static void main(String[] args) {

        Properties pro = new Properties();
        //需要掌握Properties一个存一个取:
        pro.setProperty("url","jdbc:mysql://1ocalhost:3306/bjpowernode");
        pro.setProperty("username","root");
        pro.setProperty("password","123");
        //通过key获取value

        String s1 = pro.getProperty("url");
        System.out.println(s1);
    }
}
