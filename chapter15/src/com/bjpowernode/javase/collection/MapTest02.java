package com.bjpowernode.javase.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
map集合的遍历【非常重要】
 */
public class MapTest02 {
    public static void main(String[] args) {
        //第一种方式，获取所有的KEY，通过遍历KEY，来遍历value
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");
        //遍历map集合
        //先获取所有的KEY，所有的KEY是一个set集合
        Set<Integer> keys = map.keySet();
        //遍历key，再通过key获取value(用.get()方法）
        //迭代器可以
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key+" = "+value);
        }
        //foreach也可以
        for(Integer key: keys){
            System.out.println(key+" = "+map.get(key));
        }

        //第二种方式：Set<Map.Entry<K,Y>> entrySet()
        //以上这个方法是把MAP集合直接转换成SET集合！
        //SET集合中元素的类型是Map.Entry
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //遍历set集合，每次取出一个NODE,用NODE类特有的getKey(),getValue()获取key和value
        //迭代器
        Iterator<Map.Entry<Integer,String>> it2 = set.iterator();
        while (it2.hasNext()){
            Map.Entry<Integer,String> node = it2.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key+" = "+value);
        }
        //foreach
        for (Map.Entry<Integer,String> node:set){
            System.out.println(node.getKey()+" = "+node.getValue());
        }

    }
}
