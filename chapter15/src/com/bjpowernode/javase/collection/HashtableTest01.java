package com.bjpowernode.javase.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashtableTest01 {
    public static void main(String[] args) {
        Map map = new Hashtable();
        map.put(null,100);
        map.put(1,null);
        System.out.println(map.size());
    }
}
