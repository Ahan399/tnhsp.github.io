package com.bjpowernode.javase.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest02 {
    public static void main(String[] args) throws Exception{
       /* //字节流
        FileInputStream in = new FileInputStream("D:\\IoTest\\file");
        //通过转换流转换
        InputStreamReader reader = new InputStreamReader(in);
        //这个构造方法只能传入一个字符流，不能是字节流
        BufferedReader br = new BufferedReader(reader);*/
        //合并
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IoTest\\file") ));

        String line = null;
        while ((line = br.readLine()) !=null){
            System.out.println(line);
        }
        //关闭最外层
        br.close();
    }
}
