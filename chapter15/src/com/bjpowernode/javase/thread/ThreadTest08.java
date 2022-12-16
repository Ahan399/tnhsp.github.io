package com.bjpowernode.javase.thread;
/*
sleep睡眠太久，如果希望半道上醒来，怎么唤醒一个正在睡眠的线程？
 */
public class ThreadTest08 {
    public static void main(String[] args) {

        Thread t = new Thread(new MyRunnable2());
        t.setName("t");
        t.start();
        //希望五秒后，主线程的活做完了
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此处终端t的睡眠，这种中断睡眠的方式是依靠java的异常处理机制！
        t.interrupt();//干扰，一盘冷水过去，打断睡眠状态
    }
}
class MyRunnable2 implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"-->begin");
        //run方法不能throw,只能try catch，因为子类不能比父类抛出更多的异常
        //睡眠一年
        try {
            Thread.sleep(1000*60*60*24*365);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->end");
    }


}
