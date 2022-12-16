package com.bjpowernode.javase.io;

import java.io.BufferedReader;
import java.io.FileReader;

/*
带有缓冲区的字符输出流
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) throws Exception{
        FileReader reader = new FileReader("D:\\IoTest\\file");
        //构造方法里被传进来叫：节点流
        //外部负责包装的叫：包装流、处理流
        BufferedReader br = new BufferedReader(reader);
        /*//读一行
        String fristLine = br.readLine();//读取一个文本行，但不带换行符，返回读到的字符串
        System.out.println(fristLine);

        String secondLine = br.readLine();
        System.out.println(secondLine);*/
        String s=null;
        while ((s = br.readLine() )!= null){
            System.out.println(s);
        }
        br.close();//只需关闭包装流，里面的流也会自动关闭的

    }
}
