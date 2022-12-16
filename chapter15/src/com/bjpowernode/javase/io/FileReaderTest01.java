package com.bjpowernode.javase.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
FileReader:
        文件字符输入流，只能读取普通文本,只不过读取容器变为了char[]数组
        读取文本内容，比较方便，快捷
 */
public class FileReaderTest01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            //创建文件字符输入流
            reader = new FileReader("myfile");
            //开始读
          /*  char[] chars = new char[4];
            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1){
                System.out.println(new String(chars,0,readCount));
            }
*/
            char[] chars = new char[4];
            //往数组中读
            reader.read(chars);//按照字符的方式
            for (char c:chars){
                System.out.println(c);
            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader == null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
