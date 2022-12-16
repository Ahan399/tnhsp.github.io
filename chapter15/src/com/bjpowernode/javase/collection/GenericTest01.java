package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest01 {
    public static void main(String[] args) {
        /*
        //不使用泛型机制，分析程序存在缺点
        List myList = new ArrayList();

        //准备对象
        Cat c = new Cat();
        Bird b = new Bird();

        //将对象加入到集合中

        myList.add(c);
        myList.add(b);

        //遍历集合，取出Animal的move
        Iterator it = myList.iterator();
        while (it.hasNext()){
            //没有泛型取出的都是Object
            Object obj = it.next();
           if(obj instanceof Animal){
               Animal a = (Animal)obj;
               a.move();
           }

            System.out.println(obj);
        }

         */

        //使用泛型机制
        //使用泛型机制之后List<Animal> list中只存放Animal数据

        List<Animal> myList = new ArrayList<Animal>();
        //myList.add("abc");//不能存别的数据类型了
        Cat c = new Cat();
        Bird b = new Bird();

        myList.add(c);
        myList.add(b);

        Iterator<Animal> it = myList.iterator();

        while (it.hasNext()){
           Animal a = it.next();
           //这里取出的就是泛型限定的数据类型了，不用强转
           a.move();
           if(a instanceof Cat){
               ((Cat) a).catchMouse();
           }else if(a instanceof Bird){
               ((Bird) a).fly();
           }
        }


    }
}

class Animal{
    //父类方法
    public void move(){
        System.out.println("动物在移动");
    }
}

class Cat extends Animal{
        public void catchMouse(){
            System.out.println("猫抓老鼠");
        }
}

class Bird extends Animal{
    public void fly(){
        System.out.println("鸟儿在飞翔");
    }
}