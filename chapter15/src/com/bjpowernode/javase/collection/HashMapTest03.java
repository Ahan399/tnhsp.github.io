package com.bjpowernode.javase.collection;

import java.util.HashMap;
import java.util.Map;

/*
    hashmap的key部分运行为null吗？
 */
public class HashMapTest03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        //HashMap集合运行key为null
        map.put(null,null);
        System.out.println(map.size());//1

        map.put(null,100);
        System.out.println(map.size());//1

        //通过key获取value
        System.out.println(map.get(null));//100
    }
}
