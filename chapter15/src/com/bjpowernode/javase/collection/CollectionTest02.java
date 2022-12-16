package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
    关于集合的迭代专题
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();
        //添加元素
        c.add("abc");
        c.add("def");
        c.add(100);
        c.add(new Object());
        //对集合Collection进行遍历/迭代
        //第一步：获取集合对象的迭代器对象Iterator
        Iterator it = c.iterator();
        //第二步：通过以上获取的迭代器对象，开始迭代/遍历集合

        /*
        迭代器对象Iterator的方法：
            boolean hasNext() 如果仍有元素可以迭代，则返回true
            Object next() 返回迭代的下一个元素

         */

        while (it.hasNext()){
            //不管当初存储的是什么，取出都是Object
            Object obj = it.next();
            System.out.println(obj);
        }

    }
}
