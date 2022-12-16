package com.bjpowernode.javase.thread;
/*
守护线程实现
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        //启动线程之前，将线程设置为守护线程
        t.setDaemon(true);
        t.start();

        //主线程 ：即是用户线程
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
用来备份数据的线程对象
 */
class BakDataThread extends Thread{
    @Override
    public void run() {
        int i =0;
        //即使是死循环，由于是守护线程，用户线程结束时它也会结束
        while (true){
            System.out.println(Thread.currentThread().getName() + "--->"+(++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}