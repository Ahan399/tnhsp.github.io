package com.bjpowernode.javase.thread;

import java.util.ArrayList;
import java.util.List;

/*
1、使用wait方法 和 notify方法实现"生产者和消费者模式"
2、什么是“生产者和消费者”模式？
    生产线程负责生产，消费线程负责消费
    生产线程和消费线程要达到均衡
    这是一种特殊的业务需求，在这种特殊的情况下需要使用wait和notify

3、wait和notify方法不是线程对象的方法，是普通java对象的方法
4、wait和notify方法建立在线程同步的基础之上。因为多线程要同时操作一个仓库。有线程安全问题

5.wait()_方法作用：o.wait() 让正在o对象上活动的线程t进入等待状态，并且释放掉t线程之前占有o对象的锁

6、notify(）方法作用：o.notify()让正在o对象上等待的线程唤醒，只是通知，不会释放o对象上之前占有的锁

7、模拟这样一个需求：
    仓库我们采用List集合
    LIST集合假设只能存储一个元素
    1个元素就表示仓库满了

    保证LIST集合中永远都是存储最多一个元素

    必须做到这个效果生产一个，消费一个

 */
public class ThreadTest16 {
    public static void main(String[] args) {
        //创建一个仓库对象，共享的
            List list = new ArrayList();
        //创建两个线程
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}
//生产线程
class Producer implements Runnable{
    //仓库
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产（死循环模拟一直生产）
        while (true) {
            //表示给list仓库对象加锁
            synchronized (list) {
                if (list.size() > 0) {
                    //此时仓库有一个产品了，线程进入等待状态，不能再生产了
                    //令当前线程进入等待状态，并且释放list集合的锁
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能执行到此处，证明仓库是空的
                Object obj = new Object();//创建仓库里的对象
                list.add(obj);//给仓库添加元素
                System.out.println(Thread.currentThread().getName()+" -->"+ obj);
                //此处需要唤醒消费者进行消费
                list.notify();
            }
        }
    }
}
//消费线程
class Consumer implements Runnable{
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直消费
        while (true){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        //此时仓库空了
                        //释放掉这个线程占用list的锁，让当前线程等待
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能够执行到此处，说明仓库有数据，需要进行消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "-->"+ obj);
                //唤醒生产者生产
                list.notifyAll();
            }
        }
    }
}