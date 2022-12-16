package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest03 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(new Object());
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(1);

        Iterator it = c1.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Collection c2 = new HashSet();
        //无序的HashSet集合，取出不一定是存入的顺序，而且只会存一个100（不能相同）
        c2.add(100);
        c2.add(200);
        c2.add(300);
        c2.add(90);
        c2.add(100);
        c2.add(80);

        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
