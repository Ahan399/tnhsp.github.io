package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
JDK8后引入了：自动类型推断机制（又称为钻石表达式）。
 */
public class GenericTest02 {
    public static void main(String[] args) {
        //ArrayList<>这里类型会自动推断,不需要写
        List<Animal> myList = new ArrayList<>();
        myList.add(new Animal());
        myList.add(new Cat());
        myList.add(new Bird());

        //遍历
        Iterator<Animal> it = myList.iterator();
        while (it.hasNext()){
            Animal a = it.next();
            a.move();
        }
    }
}
