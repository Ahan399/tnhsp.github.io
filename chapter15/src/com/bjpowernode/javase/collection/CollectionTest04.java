package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
深入contains方法
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //向集合中存储元素
        String s1 = new String("abc");
        c.add(s1);
        String s2 = new String("def");
        c.add(s2);
        System.out.println("元素的个数是："+c.size());

        String x = new String("abc");
        //尽管x对象并没有加入集合内
        System.out.println(c.contains(x));//ture

    }
}
