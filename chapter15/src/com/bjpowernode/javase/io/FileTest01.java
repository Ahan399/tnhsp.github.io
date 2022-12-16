package com.bjpowernode.javase.io;

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) throws Exception{
        File f1 = new File("D:\\IoTest\\file01");
        //判断是否存在
        System.out.println(f1.exists());
        //如果d盘下的file01不存在，则以文件的形式创建出来
       /* if(!f1.exists()){
            f1.createNewFile();
        }*/
        //如果不存在以目录的方式创建呢？
        if(!f1.exists()){
            f1.mkdir();
        }

        //可以创建多重目录吗？
        File f2 = new File("D:\\IoTest\\a\\b\\c");
        if(!f2.exists()){
            f2.mkdirs();
        }

        File f3 = new File("D:\\IoTest\\temp.txt");
        //获取文件路径
        String parentPath = f3.getParent();
        System.out.println(parentPath);//D:\IoTest
        //以file类的形式获取文件路径
        File parentFile = f3.getParentFile();
        //File类获取绝对路径方法
        System.out.println("获取File的绝对路径"+parentFile.getAbsoluteFile());

    }
}
