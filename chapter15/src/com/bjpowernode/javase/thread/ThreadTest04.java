package com.bjpowernode.javase.thread;
/*
采用匿名内部类
 */
public class ThreadTest04 {
    public static void main(String[] args) {
        //创建线程对象采用匿名内部类方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("分支线程--》"+i);
                }
            }
        });
        t.start();
        for (int i=0;i<100;i++){
            System.out.println("主线程--》"+i);
        }
    }
}
