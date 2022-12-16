package com.bjpowernode.javase.collection;

import java.util.LinkedList;
import java.util.List;
/*
链表优点：
    由于链表上的元素，空间存储上内存地址不连续，所以随机增删元素时不会有大量元素位移
以后开发中，如果遇到随机增删集合中的元素的业务比较多时，建议·使用LinkList

链表的缺点：
    不能通过数学表达式计算被查找的元素的内存地址，每次查找都是从头节点开始，所以Link
    集合检索/c查找的效率较低
 */
public class LinkedListTest01 {
    public static void main(String[] args) {
        //LinkList集合底层也是有下标的
        List list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
     for(int i=0;i<list.size();i++){
         Object obj = list.get(i);
         System.out.println(obj);
     }
    }
}
