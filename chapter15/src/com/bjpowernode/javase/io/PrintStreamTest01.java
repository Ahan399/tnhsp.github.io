package com.bjpowernode.javase.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

/*
标准字节输出流。默认输出到控制台
 */
public class PrintStreamTest01 {
    public static void main(String[] args) throws Exception{
        //联合起来写
        System.out.println("hello world!");

        //分开写
        PrintStream ps = System.out;//print方法重载成System.out类中的了
        ps.println("hello zhangsan");
        ps.println("hello lisi");
        ps.println("hello wangwu");
        //标准输出流不需要手动close()关闭
        //可以改变标准输出流输出方向吗？

        //标准输出流不再指向控制台，指向“log”文件。
        PrintStream printStream = new PrintStream(new FileOutputStream("log"));
        //修改输出方向，将输出方向修改到“log”文件
        System.setOut(printStream);//指定System输出的位置方法setOut
        //再输出
        System.out.println("hello world");
        System.out.println("hello Kitty");
        System.out.println("hello zhangsan");//此时这三行数据都输出到log文件上了
    }
}
