package com.bjpowernode.javase.threadsafe;
/*
银行账号类
    不使用线程同步机制，多线程对同一账号取款，出现了安全问题
 */
public class Account {
    //账号
    private String actno;
    //余额
    private double balance;

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
    public void withdraw(double money){
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
