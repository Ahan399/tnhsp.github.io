package com.bjpowernode.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest03 {
    public static void main(String[] args) {
        //1970-01-01 00:00:00:001
        Date time = new Date(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(time);
        //时间是正确的，因为北京时间是差8小时的，北京是东八区
        System.out.println(strTime);//1970-01-01 08:00:00 001
        //获取昨天此时的时间
        Date time2 = new Date(System.currentTimeMillis() - 1000*60*60*24);
        System.out.println(time2);
    }
}
