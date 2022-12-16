package com.bjpowernode.javase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;// JUC包下的，属于Java的并发包

/*
实现线程的第三种方式
    实现Callable接口
 */
public class ThreadTest15 {
    public static void main(String[] args) throws Exception{
        //创建一个未来任务类对象
        //参数需要给一个Callable接口实现对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                //Call方法就相当于run方法，只不过这个有返回值
                //线程有一个任务，只不过他执行之后可能有一个执行结果
                System.out.println("call method begin");
                Thread.sleep(1000*10);
                System.out.println("call method over");
                int a = 100;
                int b = 200;
                return a+b;
            }
        });

        //创建线程对象
        Thread t = new Thread(task);
        //启动线程
        t.start();
        //这里是main方法，在主线程中怎么获取t线程的返回结果（返回值）
        //思考，这个方法会不会阻塞主线程的执行？
        //会！
        //main方法这款程序的执行必须等待get()方法的结束
        //get()方法可能需要很久，因为get方法拿的是另一个线程的执行结果，另一个线程是需要时间的
        Object obj = task.get();

        System.out.println("main over!");
    }
}
