package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest07 {
    public static void main(String[] args) {
        //JDK8 Catch语法新特性，可以连续写几种异常
        try {
            FileInputStream fis = new FileInputStream("D:\\baiduDown\\dzx.txt");

            System.out.println(100 / 0);//这个是运行时异常，编写程序可以处理也可以不处理
        }catch (FileNotFoundException |ArithmeticException |NullPointerException e){
            System.out.println("文件不存在？数学异常？空指针异常？都有可能！");
        }
    }
}
