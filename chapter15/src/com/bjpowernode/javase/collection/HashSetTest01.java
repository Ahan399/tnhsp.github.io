package com.bjpowernode.javase.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
    public static void main(String[] args) {
        //演示hashset特点
        Set<String> strs = new HashSet<>();
        //添加元素
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("g");
        strs.add("f");
        strs.add("g");
        strs.add("g");

        for (String str:strs){
            System.out.println(str);
        }
    }
}
