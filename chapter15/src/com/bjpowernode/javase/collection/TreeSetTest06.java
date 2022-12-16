package com.bjpowernode.javase.collection;

import java.util.Comparator;
import java.util.TreeSet;

/*
TreeSet集合可排序的第二种方式：使用比较器的方式
 */
public class TreeSetTest06 {
    public static void main(String[] args) {
        //创建TreeSet集合后，需要使用这个比较器
        TreeSet<WuGui> wuguis = new TreeSet<>(new WuGuiComparator());
        wuguis.add(new WuGui(1000));
        wuguis.add(new WuGui(800));
        wuguis.add(new WuGui(200));

        for (WuGui w:wuguis){
            System.out.println(w);
        }
    }

}
//乌龟
class WuGui{
    int age;

    public WuGui(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "乌龟{" +
                "age=" + age +
                '}';
    }
}
//单独在这里编写一个比较器
class WuGuiComparator implements Comparator<WuGui> {

    @Override
    public int compare(WuGui o1, WuGui o2) {
        //规则，按照年龄大小排序
        return o1.age - o2.age;
    }
}
