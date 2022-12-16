package com.bjpowernode.javase.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterTest01 {
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\IoTest\\temp.txt",true));
        out.write("hello world!");
        out.write("\n");
        out.write("hello man!");
        out.write("\n");

        out.flush();
        out.close();

    }
}
