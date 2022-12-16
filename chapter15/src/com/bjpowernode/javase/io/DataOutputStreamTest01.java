package com.bjpowernode.javase.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest01 {
    public static void main(String[] args) throws Exception{
        //创建数据专属的字节输出流
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\IoTest\\data"));
       //写数据
        byte b = 100;
        short s =200;
        int i = 300;
        long l = 400L;
        float f = 3.0F;
        double d = 3.14;
        boolean sex = false;
        char c = 'a';
        //写
        dos.writeByte(b);//把数据以及数据的类型一并写入到文件当中
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);


        dos.flush();
        dos.close();
    }
}
