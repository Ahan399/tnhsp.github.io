package com.bjpowernode.javase.io;

import com.bjpowernode.javase.bean.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*

一次序列化多个对象，序列化集合
 */
public class ObjectOutputStreamTest02 {
    public static void main(String[] args) throws Exception{
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"zhangsan"));
        userList.add(new User(2,"lisi"));
        userList.add(new User(3,"wangwu"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IoTest\\users"));

        //一次序列化一个集合，这个集合里有很多其他对象
        oos.writeObject(userList);

        oos.flush();
        oos.close();

    }
}
