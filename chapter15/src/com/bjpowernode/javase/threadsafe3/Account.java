package com.bjpowernode.javase.threadsafe3;
/*
银行账号类
    使用线程同步机制，多线程对同一账号取款，解决安全问题
 */
public class Account {
    //账号
    private String actno;
    //余额
    private double balance;
    //对象
    Object obj = new Object();//实例变量()

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款的方法
    public synchronized void withdraw(double money){

        //以上这几行代码必须是线程排队的，不能并发
        /*//线程同步机制的语法是：
            synchronized (){
               //线程同步代码块
            }
            synchronized后面小括号中传的这个"数据"是相当关键的
            这个数据必须是多线程共享的数据。才能达到多线程排队

            ()中写什么?
                那要看你想让哪些线程同步
                假设t1,t2,t3,t4,t5...有五个线程
                你只希望t1,t2,t3排队，t4,t5不需要排队怎么办？
                一定要在()中写一个t1,t2,t3共享的对象。而这个对象对于t4,t5来说不是共享的

               这里的共享对象是：账号对象
               账号对象是共享的，在这个类里就是this!!
            */

            //取款之前的余额
            double before = this.getBalance();
            //取款之后的余额
            double after = before - money;
            //这里模拟一下网络延迟，100%出现问题
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新余额
            //t1执行到这里，但还来得及执行这行代码，而t2线程进来withdraw方法，一定酒出现了问题
            this.setBalance(after);



    }


}
