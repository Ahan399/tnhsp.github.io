package com.bjpowernode.javase.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws Exception{
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true); //设定为守护线程

        //指定定时任务
        //timer.schedule(定时任务,第一次执行时间,间隔多久执行一次);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date fristTime =  sdf.parse("2022-03-14 09:30:00");
        timer.schedule(new LogTimerTask(),fristTime,1000 * 10);

    }
}
//编写一个定时任务类
class LogTimerTask extends TimerTask{

    @Override
    public void run() {
        //编写你需要执行的任务就行了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());

        System.out.println(strTime+" 数据已自动备份");
    }
}
