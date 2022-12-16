package com.bjpowernode.javase.threadsafe;

public class AccountThread extends Thread{

    //两个线程必须共享一个账号对象
    private Account act;
    //构造方法传入一个账号对象
    public AccountThread(Account act) {
        this.act = act;
    }

    public void run() {
        //run的执行代表取款操作
        //假设取款5000
        double money = 5000;
        //取款
        act.withdraw(money);
        System.out.println(Thread.currentThread().getName()+"对账户："+act.getActno()+" 取款"+money+"成功，账号余额为："+act.getBalance());
    }
}
