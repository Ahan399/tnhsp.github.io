package com.bjpowernode.javase.thread;
/*
关于sleep方法的一个面试题
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        MyThread3 t = new MyThread3();
        t.setName("tt");
        t.start();
        //调用sleep方法
        try {
            //这行代码会让线程t进入休眠专状态吗？
            //不会
            t.sleep(1000*5);//它是一个静态方法，跟对象没关系
            //这行代码作用其实是让main线程进入休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //所以这条代码才会在五秒后才执行哦！
        System.out.println("hello world!");
    }
}
class MyThread3 extends Thread{
    public void run(){
        for(int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
