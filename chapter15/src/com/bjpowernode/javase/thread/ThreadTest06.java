package com.bjpowernode.javase.thread;

public class ThreadTest06 {
    public static void main(String[] args) {
        //让当前线程（主线程）进入休眠，休眠五秒
        /*try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world!");*/
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "-->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
