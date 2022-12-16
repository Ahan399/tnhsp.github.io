package com.bjpowernode.javase.collection;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        //AarrayList不是线程安全的
        List<String> list = new ArrayList<>();
        //变成线程安全
        Collections.synchronizedList(list);

        //排序
        list.add("abc");
        list.add("abx");
        list.add("abc");
        list.add("abe");

        Collections.sort(list);
        for (String s :list){
            System.out.println(s);
        }

        List<WuGui2> wuGuis = new ArrayList<>();
        wuGuis.add(new WuGui2(1000));
        wuGuis.add(new WuGui2(8000));
        wuGuis.add(new WuGui2(600));
        //注意：对list的元素进行排序，需要保证LIST集合中的元素实现：Comparable接口
        Collections.sort(wuGuis);
        for(WuGui2 w : wuGuis){
            System.out.println(w);
        }

        //对Set集合怎么排序呢
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingsoft");
        set.add("king1");
        set.add("king2");
        //sort方法只能传入list集合
        List<String> myList = new ArrayList<>(set);
        Collections.sort(myList);
        for(String s: myList){
            System.out.println(s);
        }
    }
}
class WuGui2 implements Comparable<WuGui2>{
    int age;

    public WuGui2(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "乌龟{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(WuGui2 o) {
        return this.age - o.age;
    }
}