package com.bjpowernode.javase.io;

import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter:
    文件字符输出流，只能输出普通文本
 */
public class FileWriterTest01 {
    public static void main(String[] args) {
        FileWriter out =null;
        try {
            //创建输出流对象
            out = new FileWriter("D:\\IoTest\\file");
            //开始写
            //write()可以传入一个char[]数组，也能传入一个字符串
            char[] chars = {'我','是','中','国','人'};
            out.write(chars);
            out.write(chars,2,3);

            out.write("我要当太空人");

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
