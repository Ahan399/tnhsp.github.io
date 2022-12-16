package com.bjpowernode.javase.collection;

import java.util.TreeSet;

/*
对自定义类型来说,TreeSet可以排序吗?
    不行，而且会报错！
    因为这个类没有排序规则，添加元素后，元素之间无法排序！
    异常原因：Person类没有实现比较器接口Comparable,不能转成接口Comparable
    collection.Person cannot be cast to class java.lang.Comparable

    结论：
    放在TreeSet集合中的元素需要实现java.lang.Comparable接口
    并且实现compareTo方法（由程序员指定规则）。equals可以不写了（因为比较过大小后，返回值0可看作元素相等）
 */
public class TreeSetTest03 {
    public static void main(String[] args) {

        Customer c1 = new Customer(32);
        Customer c2 = new Customer(20);
        Customer c3 = new Customer(30);
        Customer c4 = new Customer(25);
        //创建TreeSet集合
        TreeSet<Customer> customers = new TreeSet<>();
        customers.add(c1);
        customers.add(c2);//添加第二个person时就会出异常，因为这个类没有排序规则，无法和第一个元素排序！
        customers.add(c3);
        customers.add(c4);

        //遍历
        for (Customer c: customers){
            System.out.println(c);
        }
    }
}

class Person{
    int age;

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

//放在TreeSet集合中的元素需要实现java.lang.Comparable接口
//并且实现compareTo方法。equals可以不写了（因为比较过大小后，返回值0可看作元素相等）
class Customer implements Comparable<Customer>{
    int age;

    public Customer() {
    }

    public Customer(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                '}';
    }

    //需要在这个方法编写比较逻辑，或者比较规则，按什么来比较
    //底层：k.compareTo(t.key)
    //拿着参数k和集合中每一个K进行比较，返回值可能大于小于等于0
    //比较规则最终由程序员指定，按年龄升序或者降序
    @Override
    public int compareTo(Customer c) {

        return this.age - c.age;//可以返回三种结果，这种写法节省代码量
    }
}