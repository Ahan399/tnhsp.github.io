package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest01 {
    public static void main(String[] args) {
        //默认初始化容量是10
        List list1 = new ArrayList();
        //size()方法是获取当前集合中元素的个数，不是容量！
        System.out.println(list1.size());//0
        //默认初始化容量为20
        List list2 = new ArrayList(20);
        System.out.println(list2.size());//0

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        System.out.println(list1.size());
        //再添加一个元素
        list1.add(11);

    }
}
