package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
关于java.util.Collection接口常用方法。
    1.Collection中能存放什么元素？
        没有使用“泛形”，可以存储所有Object子类型元素
        使用“泛形”后，只能存储某个的具体类型
        Object子类型，集合中不能直接存储基本数据类型，也不能存储java对象，
        只能存储java对象的内存地址
     2.Collection常见方法：
        boolean add(Object e) 向集合添加元素
        int size() 返回集合中元素个数
        void clear() 清空集合
        boolean contains(Object o) 判断当前集合中是否保护元素o,包含返回ture
        void remove(Object o) 删除集合中某个元素
        boolean isEmpty() 判断该集合在的元素个数是否为0,ture代表集合中没元素了
        Object[] toArray() 调用这个方法可以把集合转换为数组。

 */
public class CollectionTest01 {
    public static void main(String[] args) {
        //创建一个集合对象
        //多态，创建一个ArrayListL类，父接口指向
        Collection c = new ArrayList();
        //测试
        c.add(1200);//此处自动装箱了，因为1200是基本数据类型，把包装类的内存地址存放进去了！
        c.add(3.14);
        c.add(new Object());
        c.add(true);
        c.add(new Student());

        //获取集合中元素数量
        System.out.println("集合中元素个数是"+c.size());
        //清空集合
        c.clear();
        System.out.println("集合中元素个数是"+c.size());//0
        //再添加元素
        c.add("hello");
        c.add("world");
        c.add("浩克");
        c.add("绿巨人");
        c.add(1);
        //判断集合中是否包含绿巨人
        boolean flag = c.contains("绿巨人");
        System.out.println(flag);
        boolean flag2 = c.contains("绿巨人2");
        System.out.println(flag2);
        System.out.println(c.contains(1));//ture
        System.out.println("集合中元素个数是"+c.size());//5

        //删除集合中某个元素
        c.remove(1);
        System.out.println(c.contains(1));//false
        System.out.println("==============");

        //判断集合中是否为空，是否存在元素
        System.out.println(c.isEmpty());//false
        c.clear();
        System.out.println(c.isEmpty());//ture
        System.out.println("==============");

        c.add("abc");
        c.add("def");
        c.add("hello world");
        c.add(new Student());
        //将集合转换为数组
        Object[] objs = c.toArray();
        for(int i =0;i< objs.length;i++){
            Object o = objs[i];
            System.out.println(o);
        }
    }

}
class Student{

}