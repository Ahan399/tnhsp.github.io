package com.bjpowernode.javase.thread;

public class ThreadTest02 {
    public static void main(String[] args) {
        //这里是main方法，这里代码属于主线程，在主线中运行
        MyThread myThread = new MyThread();
        //myThread.run();
        myThread.start();//start()方法作用是，在jvm中开辟一个新的栈空间，启动一个分支线程
        for(int i=0;i<1000;i++){
            System.out.println("主线程---》"+i);
        }
    }
}

class MyThread extends Thread{
        public void run(){
            //编写程序，这段程序运行在分支线程中（分支栈）
            for(int i =0;i< 1000;i++){
                System.out.println("线程分支--》"+i);
            }
        }
}