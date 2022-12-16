package com.bjpowernode.javase.date;
/*
获取自1970年1月1日 00：00：00 000当前系统时间的总毫秒数
1秒 = 1000毫秒
 */
public class DateTest02 {
    public static void main(String[] args) {
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println(nowTimeMillis);

        //需求：统计一个方法执行所耗费的时长
        long begin = System.currentTimeMillis();
        //在调用目标方法前记录一个毫秒数
        print();
        //在执行完目标方法之后记录一个毫秒数
        long end = System.currentTimeMillis();
        System.out.println("耗费时长"+(end - begin)+"毫秒");
    }
    public static void print(){
        for(int i=0;i<1000;i++){
            System.out.println("i="+i);
        }
    }
}
