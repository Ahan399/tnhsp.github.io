package com.bjpowernode.javase.thread;
/*
获取当前线程对象
    获取当前线程对象的名字、修改名字
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        //获取当前线程对象
        //代码出现在main中，所以当前线程就是主线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        MyThread2 t = new MyThread2();
        //设置线程的名字
        t.setName("tttt");//若不传入值，则默认名为Thread-0、Thread-1....以此类推
        //获取线程的名字
        System.out.println(t.getName());
        //启动线程
        t.start();
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
       for(int i=0;i<100;i++){
           //t1执行run，当前线程就是t1
           //t2执行run，当前线程就是t2
           Thread currentThread = Thread.currentThread();
           System.out.println(currentThread.getName());//与this类似，能探测出是哪个对象
           System.out.println("分支线程--》"+i);
       }
    }
}