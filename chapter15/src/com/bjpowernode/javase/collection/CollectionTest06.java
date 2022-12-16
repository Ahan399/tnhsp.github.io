package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
关于集合元素的remove
 */
public class CollectionTest06 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //Iterator it = c.iterator();
        c.add(1);//其实是Integer类型！
        c.add(2);
        c.add(3);
        //获取迭代器
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        Collection c2 = new ArrayList();
        c2.add("abc");
        c2.add("def");
        c2.add("xyz");

        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            Object o = it2.next();
            //删除元素后，集合元素就发生了变化
            //c2.remove(o);
            it2.remove();//删除迭代器指向的当前元素,用迭代器自带的remove就可以删除成功
            System.out.println(o);
        }
        System.out.println(c2.size());//0
    }

}
