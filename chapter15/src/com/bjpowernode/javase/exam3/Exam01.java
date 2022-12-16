package com.bjpowernode.javase.exam3;
//面试题：doOther方法执行的时候需要等待doSome方法的结束吗？
    //不需要，两个实例对象互不影响
public class Exam01 {
    public static void main(String[] args) {
        MyClass mc1 = new MyClass();
        MyClass mc2 = new MyClass();
        Thread t1 = new MyThread(mc1);
        Thread t2 = new MyThread(mc2);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);//为了保证t1线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class MyThread extends Thread{
    private MyClass mc;

    public MyThread(MyClass mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")){
            mc.doSome();
        }
        if (Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }
    }
}

class MyClass{
    //synchronized出现在实例方法上，表示锁this
    public synchronized void doSome(){
        System.out.println("doSome begin");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }
    //有synchronize表示需要找到锁才执行，在找锁找不到，便实现排队执行了
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}