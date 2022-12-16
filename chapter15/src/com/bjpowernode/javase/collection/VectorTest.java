package com.bjpowernode.javase.collection;

import java.util.*;

public class VectorTest {
    public static void main(String[] args) {

        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);
        //满了扩容
        vector.add(11);

        Iterator it = vector.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        List myList = new ArrayList();//非线程安全
        //通过工具类变成线程安全
        Collections.synchronizedList(myList);
        myList.add("111");
        myList.add("222");
        myList.add("333");

    }
}
