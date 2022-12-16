package com.bjpowernode.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) throws Exception{
        //获取系统当前时间
        Date nowTime = new Date();
        System.out.println(nowTime);
        //将日期类型Date按照指定的格式进行转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        String nowTimeStr = sdf.format(nowTime);
        System.out.println(nowTimeStr);

        //假如有一个日期String
        String time = "2008-08-09 10:08:08 888";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date dateTime = sdf2.parse(time);
        System.out.println(dateTime);
    }
}
