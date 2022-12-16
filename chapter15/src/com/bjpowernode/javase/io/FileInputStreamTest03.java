package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    int read(byte[] b) 一次最多读取b.length个字节,减少硬盘和内存的交互，提高程序的执行效率
    往byte[] 数组当中读


 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //路径是相对路径的话呢，相对路径一定是当前所在位置开始寻找
            //IDEA默认的当前路径是哪里？在整一个工程根文件路径下
            fis = new FileInputStream("D:\\IoTest\\temp.txt");
            //开始读，采用byte数组，一次读取多个字节，最多读取 数组.length个字节
            byte[] bytes = new byte[4];//准备一个长度4的字节数组
            //这个方法的返回值是，读取到的字节数量（不是字节本身了！）
            int readCount = fis.read(bytes);
            System.out.println(readCount);//4 ，第一次读到4个字节
            /*
            System.out.println(new String(bytes));//abcd
            *
             */
            System.out.println(new String(bytes,0,readCount));//这样写，就可以实现读到几个写几个

            readCount = fis.read(bytes);
            System.out.println(readCount);//2 , 第二次只能读取到个字2节
            /*
            System.out.println(new String(bytes));//efcd,第二次读取如果满了会从第一位开始覆盖
            */
            //结论：不应该全部都转换，应该是读取到多少个字节转换多少个
            System.out.println(new String(bytes,0,readCount));

            readCount = fis.read(bytes);
            System.out.println(readCount);//-1 , 第三次一个字节都没有读到，返回-1

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
