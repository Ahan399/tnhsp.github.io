package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类的其他常用方法：
        int available(); 返回流当中剩余的没有读到的字节数量
        long skip(long n); 跳过几个字节不读
 */
public class FileInputStreamTest05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IoTest\\temp.txt");
            System.out.println("总字节数量："+fis.available());
          /*  //读一个字节
            int readByte = fis.read();
            //还剩下几个字节？
            System.out.println("剩下的字节数量："+fis.available());*/
            //这个方法有什么用？
          /*  byte[] bytes = new byte[fis.available()];//这种方式不太适合太大的文件，因为byte数组不能太大
            //不需要循环了。
            //直接读一次就行
            int readCount = fis.read(bytes);//6
            System.out.println(new String(bytes));// abcdef*/

            // skip 跳跃几个字节不读取，这个方法也可能以后会用

            fis.skip(3);
            System.out.println(fis.read());


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
