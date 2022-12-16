package com.bjpowernode.javase.thread;
/*
合理终止一个线程的执行
 */
public class ThreadTest10 {
    public static void main(String[] args) {
        MyRunnable4 r=new MyRunnable4();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();
        //模拟五秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程
        //想要什么时候终止t的执行，把run属性修改为false就行
        r.run=false;

    }
}
class MyRunnable4 implements Runnable{

    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(run) {
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //return酒结束了，你在结束之前还有什么没保存的在这里酒可以保存
                //终止当前线程
                return;
            }


        }

    }


}