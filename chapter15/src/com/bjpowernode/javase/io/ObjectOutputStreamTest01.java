package com.bjpowernode.javase.io;

import com.bjpowernode.javase.bean.Student;
import com.bjpowernode.javase.bean.Student2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
/*
序列化
如果对象不实现可序列化接口则会报错不能实现序列化
 */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) throws Exception{
        //创建Student对象
        Student2 s = new Student2(111,"zhangsan");
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students"));
        //序列化对象
        oos.writeObject(s);

        //刷新
        oos.flush();
        oos.close();
    }
}
