package com.bjpowernode.javase.string;
/*
关于String类中的构造方法
 */
public class StringTest04 {
    public static void main(String[] args) {
        //创建字符串最常用的一种方式
        String s1 = "hello world!";
        //这里只掌握常用的构造方法
        byte[] bytes = {97,98,99};//97是a，98是b，99是c
        //传入一个byte数组
        String s2 = new String(bytes);
        System.out.println(s2);
        //有时候未必要构造完整的bytes数组！
        //还可以添加偏移量，和持续长度：String(字节数组,数组元素下标起始位置,长度);
        String s3 = new String(bytes,1,2);
        System.out.println(s3);

        //以此类推，字节数组也类似
        char[] chars = {'我','是','中','国','人'};
        String s4 = new String(chars);
        System.out.println(s4);
        String s5 = new String(chars,2,3);
        System.out.println(s5);
    }
}
