package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    List特有常用方法：

        void add(int index, Object element) 在指定下标位置添加元素
        Object get(int index) 根据下标获取元素
        int indexOf(Object o) 获取指定对象第一次出现过的索引
        int LastIndexOf(Object o) 获取指定对象最后一次出现过的索引
        Object remove(int index) 根据下标删除指定元素
        Object set(int index,Object element) 修改指定下标位置的元素
     */
public class ListTest01 {
    public static void main(String[] args) {
        List myList = new ArrayList();
        //添加元素
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        //该方法使用不多，对于ArrayList集合来说效率比较低
        myList.add(1,"King");


        //迭代
        Iterator it = myList.iterator();
        while (it.hasNext()){
            Object elt = it.next();
            System.out.println(elt);
        }
        //获取下标元素
        Object firstObj = myList.get(0);
        System.out.println(firstObj);
        //因为有下标list有独特遍历方式
        for(int i=0;i<myList.size();i++){
            Object obj = myList.get(i);
            System.out.println(obj);
        }
        //获取指定对象第一次出现过的索引
        System.out.println(myList.indexOf("King"));//1
        //获取指定对象最后一次出现处的索引
        System.out.println(myList.indexOf("C"));//3
        //根据下标删除指定元素
        myList.remove(0);
        System.out.println(myList.size());//4
        //修改指定下标元素
        myList.set(2,"Sort");
        System.out.println("===================");
        for(int i=0;i<myList.size();i++){
            Object obj = myList.get(i);
            System.out.println(obj);
        }
    }
}
