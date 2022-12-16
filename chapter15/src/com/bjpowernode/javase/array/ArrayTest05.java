package com.bjpowernode.javase.array;
/*
1.main方法上面”String[] args"有什么用？
    分析以下：谁负责调用main方法（JYM）
    JVM调用main方法的时候，会自动传一个String数组过来
 */
public class ArrayTest05 {
    //这个方法程序员负责写出来，JVM负责调用，JVM一定会传一个String数组过来
    public static void main(String[] args) {
        //JVM默认传递过来的这个数组对象长度？默认0
        //通过测试得出：args不是null
        System.out.println("JVM传过来的String数组参数长度是："+args.length);//输出结果为0
        //其实就等同于：
        //String[] strs = new Sting[0];
        //Sting[] strs = {};

        //这个数组什么时候会有值呢？
        //其实这个数组是留给用户的，用户可以在控制台上输入参数，这个参数自动会被转换为String[] args
        //例如这样运行程序：java ArrayTest05 abc def xyz
        //那么这个时候JVM会自动将"abc def xyz"通过空格方式进行分离，分离完成之后，自动放到"String[] args"数组
        //所以main方法上面的String[] args 数组主要是用来接受用户输入参数的。
        //把abc def xyz 转换为字符串数组:{"abc","def","xyz"}

        for(int i=0;i< args.length;i++){
            System.out.println(args[i]);
        }

        //用IDEA在运行--》编辑配置--》程序参数 中可以输入参数，传给main

    }
    public static void printArray(String[] args){

    }
}
