package com.bjpowernode.javase.io;

import java.io.File;

public class FileTest03 {
    public static void main(String[] args) {
        File f = new File("D:\\IoTest");
        File[] files = f.listFiles();//拿到该目录下的所有file,放入file数组
        //遍历
        for(File file: files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
