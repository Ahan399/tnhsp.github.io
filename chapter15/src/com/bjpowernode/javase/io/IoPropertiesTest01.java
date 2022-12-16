package com.bjpowernode.javase.io;

import java.io.FileReader;
import java.util.Properties;

public class IoPropertiesTest01 {
    public static void main(String[] args) throws Exception{
        /*
        想将userinfo文件中的数据加载到Properties对象中
         */
        //创建一个输入流对象
        FileReader reader = new FileReader("userinfo.properties");
        //新建一个Map集合
        Properties pro = new Properties();
        //将文件中的数据加载到Map集合中，通过load方法
        pro.load(reader);//文件中的数据顺着管道加载到map集合中，其中等号左边做KEY，右边做Value
        //通过key来获取value
        String username = pro.getProperty("username");
        System.out.println(username);
        String datas = pro.getProperty("data");
        System.out.println(datas);
    }
}
