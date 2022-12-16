package com.bjpowernode.javase.io;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
日志工具,以后标准输出流可以类似这样运用到工作中
 */
public class Logger {
    public static void log(String msg){
        //记录日志的方法
        try {
            //标准输出流指向一个日志文件
            PrintStream out = new PrintStream(new FileOutputStream("log.txt",true));
            //改变输出方向
            System.setOut(out);
            Date nowTime = new Date();
            //把这个系统当前时间date自定义格式化一下
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);

            System.out.println(strTime+"："+ msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
