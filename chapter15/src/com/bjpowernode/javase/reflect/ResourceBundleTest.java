package com.bjpowernode.javase.reflect;

import java.util.ResourceBundle;

/*
资源绑定器
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        //资源绑定器，只能绑定xxx.properties文件，而且必须在类路径下
        //并且在写路径的时候，路径后面的拓展名不能写
        ResourceBundle bundle = ResourceBundle.getBundle("com/bjpowernode/javase/reflect/db");

        //获取key的value
        String className = bundle.getString("className");
        System.out.println(className);

    }
}
