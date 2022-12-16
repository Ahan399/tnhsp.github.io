package com.bjpowernode.javase.reflect;
/*
可变长度参数：
    int... args 这就是可变长度参数
    类型跟三个点...
 */
public class ArgsTest {
    public static void main(String[] args) {
        m();
        m(10);
        m(10,20);

        m2(100,"abc");
        m2(200);

        m3("ab","da","ff");
        //可以传入一个数组
        String[] strs = {"a","b","c"};
        m3(strs);
    }
    public static void m(int... args){
        System.out.println("m方法执行了");
    }
    public static void m2(int a,String...args1){

    }
    public static void m3(String...args){
        for (int i = 0; i < args.length ; i++) {
            System.out.println(args[i]);
        }
    }
}
