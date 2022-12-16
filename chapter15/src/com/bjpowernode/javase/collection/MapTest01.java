package com.bjpowernode.javase.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    1.Map和Collection没有继承关系
    2.Map集合以key和value的方式存储数据：键值对
        key和value都是引用数据类型
        key和value都是存储对象的内存地址
        key起到主导的地位，value是key的附属体
     3.Map接口中常用方法：

        V put(k key,V value) 向Map集合中添加键值对
        V get(Object key) 通过KEY获取value
        void clear() 清空map集合
        boolean containsKey(Object key) 判断Map中是否包含某个KEY
        boolean containsValue(Object value) 判断MAP在是否包含某个value
        boolean isEmpty() 判断MAP集合中元素个数是否为0
        Set<K> keySet() 获取MAP集合中所有的KEY（所有的键是一个SET集合）
        V remove(Object key) 根据KEY值，删除整个键值对
        int size() 获取MAP集合中键值对的个数
        Collection<v> values() 获取集合所有value，返回一个Collection集合

        Set<Map.Entry<K,V>> entrySet() 将MAP集合转换为SET集合（key=value的字面形式）
            转换出set集合，集合中元素泛型的类型是 Map.Entry<K,V>，是一种类名！
            Map.Entry是MAP中的静态内部类
 */
public class MapTest01 {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<Integer,String> map = new HashMap<>();
        //向Map集合中添加键值对
        map.put(1,"zhangsan");//1在这里进行了自动装箱
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");
        map.put(5,"laoba");
        //通过key获取value
        String value = map.get(2);
        System.out.println(value);
        //获取键值对数量
        System.out.println("键值对的数量是："+map.size());//5
        //通过key值删除key-value
        map.remove(3);
        System.out.println("键值对的数量是："+map.size());//4
        //判断是否包含某个key
        //contains系列的方法都是底层用equals比较的，自定义类需要重新equals方法！
        System.out.println(map.containsKey(3));//false
        //判断是否包含某个value
        System.out.println(map.containsValue("zhangsan"));//true

        //获取所有的value集合
        Collection<String> values = map.values();
        //遍历获取的collection value集合
        for(String s:values){
            System.out.println(s);
        }

        //清空map集合
        map.clear();
        System.out.println("键值对的数量是："+map.size());//0
        //判断是否没空（没有元素）
        System.out.println(map.isEmpty());//true
    }
}
