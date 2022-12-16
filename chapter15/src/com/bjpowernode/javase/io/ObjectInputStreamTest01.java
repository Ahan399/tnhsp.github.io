package com.bjpowernode.javase.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest01 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students"));
        //开始反序列化，读
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }
}
