package com.bjpowernode.javase.io;

import com.bjpowernode.javase.bean.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/*
集合反序列化
 */
public class ObjectInputStreamTest02 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IoTest\\users"));

        /*Object obj = ois.readObject();
        System.out.println(obj);//ture*/
        List<User> userList = (List<User>)ois.readObject();
        for (User user : userList){
            System.out.println(user);
        }
        ois.close();
    }
}
