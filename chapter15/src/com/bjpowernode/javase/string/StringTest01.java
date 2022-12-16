package com.bjpowernode.javase.string;

/**
 * 关于java JDK中内置的一个类：java.lang.String
 *      1.String表示字符串，属于引用数据类型
 *      2.在java中随意使用双引号括起来的都是String对象。例如：“abc"...
 *      3.java中规定，双引号括起来的字符串，是不可变的,"abc"自出生到死亡不能变成别的东西
 *      4.在JDK当中双引号的字符串，都是直接存储在”方法去“的”字符串常量池”当中的
 *          为什么要把字符串存储在“字符串常量池"当中呢？
 *          因为在实际开发中使用太过频繁，为了提高执行效率，放到了”字符串常量池“中
 */
public class StringTest01 {
    public static void main(String[] args) {
        String s1 = "abcdf";
        String s2 = "abcdf"+"xy";//违反了之前的存储方式，引用指向了方法区内！而不是在堆内创建新对象！
        //用new方式的String，代码的”xy"从和而来？
        //双引号下的xy一定是在方法区内的常量池里的
        //若用来new方法则会在堆中创建了一个指向方法区的内存地址，与上面的创建方法又不同了！
        String s3 = new String("xy");
    }
}
