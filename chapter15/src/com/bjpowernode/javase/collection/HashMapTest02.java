package com.bjpowernode.javase.collection;

import com.bjpowernode.javase.bean.Student;

import java.util.HashSet;
import java.util.Set;

/*
   1. 注意：如果一个类的equals方法重写了，hashCode也必须重写
        如果equals方法返回true(说明两个元素在同一个单向链表上），那么hashCode()方法返回的值也必须一致
        因为同一链表上的节点的数组坐标是一样的，所以hashCode方法返回的值也是一样的

   2. hashCode方法直接用IDEA生成，但两个要同时生成！

   3. 终极结论：
        放在HashMap集合key部分的，以及放在HashSet集合中的元素，需要同重写hashCode方法和equals方法
 */
public class HashMapTest02 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan");
        Student s2 = new Student("zhangsan");
        //重写equals方法之前是false
        /*
        System.out.println(s1.equals(s2));//false
        */
        //重写equals后是true
        System.out.println(s1.equals(s2));
        //没有重写hashCode的方法返回的是Object的hashCode方法，返回目标对象的内存地址
        //所以s1和s2的内次地址绝对是不一样的
        System.out.println("s1的hashCode = "+s1.hashCode());
        System.out.println("s2的hashCode = "+s2.hashCode());
        //s1.equals(s2)结果已经是true了，表示s1和s2是一样的，相同的，那么由HashSet集合中放的话
        //按说只能放进去一个。（HashSet集合特点：无序不可重复）
        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        //因为它们的hashCode方法返回的值必定不同，所以数组下标也不同，所以有两个数组元素对象
        System.out.println(students.size());//按说结果是1，但其实是2，此处发生了不合理
    }
}
