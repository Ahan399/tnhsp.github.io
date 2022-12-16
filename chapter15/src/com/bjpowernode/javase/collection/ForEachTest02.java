package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachTest02 {
    public static void main(String[] args) {
        //添加List集合
        List<String> strList = new ArrayList<>();
        //添加元素
        strList.add("hello");
        strList.add("world!");
        strList.add("kitty!");

        //使用迭代器方式变量
        Iterator<String> it = strList.iterator();
        while (it.hasNext()){
            String s =it.next();
            System.out.println(s);
        }

        //使用下标方式（只针对有下标的集合）
        for(int i=0;i < strList.size();i++){
            System.out.println(strList.get(i));
        }
        //使用foreach
        for(String s: strList){
            System.out.println(s);
        }

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        for(Integer x:list){
            System.out.println(x);
        }

    }
}
