package com.bjpowernode.javase.io;

public class LogTest {
    public static void main(String[] args) {
        //测试工具类是否好用
        Logger.log("调用了System类的gc()方法，建议启动垃圾回收");
        Logger.log("异常1");
        Logger.log("异常2");
    }
}
