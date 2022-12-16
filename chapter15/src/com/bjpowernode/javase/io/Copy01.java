package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
使用FileInputStream + FileOutputStream 完成文件的拷贝
拷贝的过程应该是一边读一边写
使用以上的字节流拷贝文件的是、文件类型随意、万能。什么样的文件都能拷贝
 */
public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建一个输入流对象
            fis = new FileInputStream("C:\\Users\\AHan\\Pictures\\Saved Pictures\\滑稽.jpg");
            //创建一个输出流对象
            fos  = new FileOutputStream("D:\\IoTest\\复制过来的滑稽.jpg");//没有则创建
            // 最核心的：一边读一边写
            byte[] bytes = new byte[1024 * 1024];//一次最多拷贝1m
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes,0,readCount);//把获取到内容的byte[]的内容写入输出流
            }
            //刷新，输出流要刷新
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //分开try,否则可能有一个流关不到
            if (fos == null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
