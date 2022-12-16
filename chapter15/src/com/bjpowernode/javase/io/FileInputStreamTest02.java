package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
优化test01的代码，采用循环对出数据字节

分析这个程序的缺点：
    一次读取一个字节byte,这样内存和硬盘交互太频繁，消耗太多资源
 */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IoTest\\temp.txt");
            /*
            while (true){
                int readData = fis.read();
                if(readData == -1){
                    break;
                }
                System.out.println(readData);
            }
            */
            //改造while循环
            int readData = 0;
            while ((readData = fis.read() )!= -1){
                System.out.println(readData);
            }

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
