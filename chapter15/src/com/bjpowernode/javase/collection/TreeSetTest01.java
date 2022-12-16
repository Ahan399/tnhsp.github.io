package com.bjpowernode.javase.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest01 {
    public static void main(String[] args) {
        Set<String> strs = new TreeSet<>();
        //添加元素
        strs.add("a");
        strs.add("b");
        strs.add("g");
        strs.add("e");
        strs.add("f");
        strs.add("c");
        //遍历
        for (String s: strs){
            System.out.println(s);
        }
    }
}
