package com.bjpowernode.javase.reflect;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class IoPropertiesTest {
    public static void main(String[] args) throws Exception{
        //获取一个文件的绝对路径！
       /* String path = Thread.currentThread().getContextClassLoader()
                .getResource("com/bjpowernode/javase/reflect/db.properties").getPath();

        FileReader reader = new FileReader(path);

        */
        //以上两个步骤的高级合并！直接输入类相对路径以流形式返回！
        InputStream reader = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bjpowernode/javase/reflect/db.properties");


        Properties pro = new Properties();
        pro.load(reader);
        reader.close();

        //通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);
    }
}
