package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest10 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\baiduDown");
            String s =null;
            s.toString();
            //流使用完需要关闭，即使程序异常也要关闭
            //放在这可能关不了
            //fis.close();
            System.out.println("hello world");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }finally {
            System.out.println("执行到finally");
            if(fis != null) {//避免空指针异常，fis是空就开不了流
                try {
                    fis.close();//路径不存在可能会有空指针异常
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("catch到了");
    }
}
