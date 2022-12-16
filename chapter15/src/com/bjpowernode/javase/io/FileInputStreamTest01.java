package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
		Java.io.FileInputStream
        1.文件字节输出流，万能的，任何类型的文件都可以采用这个流来读
        2.字节的方式，完成输入的操作，完成读的操作（从硬盘 --》 内存）
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        FileInputStream fis = null;//fis写在外面，否则finally找不到

        try {
            //创建文件字节输出流对象
            fis = new FileInputStream("D:\\IoTest\\temp.txt");
            //开始读
            int readData = fis.read();//指针向前移动一位字节，返回读到的“字节”本身,当读取不到字节后返回-1
            System.out.println(readData);//97
            readData = fis.read();
            System.out.println(readData);//98...

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在finally语句块中确保流一定关闭
            if (fis == null) {//避免空指针异常
                //关闭流的前提是：流不是空，流是null没必要关闭
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}
