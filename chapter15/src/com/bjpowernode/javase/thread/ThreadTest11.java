package com.bjpowernode.javase.thread;
/*
关于线程优先级
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        //设置主线程的优先级为1
        Thread.currentThread().setPriority(1);

       /* System.out.println("最高优先级"+Thread.MAX_PRIORITY);
        System.out.println("最低优先级"+Thread.MIN_PRIORITY);
        System.out.println("默认优先级"+Thread.NORM_PRIORITY);*/

        Thread currentThread = Thread.currentThread();

       /* System.out.println(currentThread.getName()+"线程的默认优先级是"+currentThread.getPriority());*/

        Thread t = new Thread(new MyRunnable5());
        t.setPriority(10);
        t.setName("t");
        t.start();
        //优先级较高，大概率抢到cpu时间片
        for(int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+ i);
        }

    }
}
class MyRunnable5 implements Runnable{
    @Override
    public void run() {
        //获取线程优先级
        /*System.out.println(Thread.currentThread().getName()+"线程的默认优先级是"+Thread.currentThread().getPriority());*/

        for (int i = 0; i <10000 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }

    }
}