package com.bjpowernode.javase.thread;
/*
合并线程
 */
public class ThreadTest13 {
    public static void main(String[] args) {
        System.out.println("main begin");

        Thread t = new Thread(new MyRunnable7());
        t.setName("t");
        t.start();
        //合并线程
        try {
            t.join();//t合并到当前线程，当前线程(此处是main)受阻塞，T线程执行，直到结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main over");
    }
}
class MyRunnable7 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+ i);
        }
    }
}