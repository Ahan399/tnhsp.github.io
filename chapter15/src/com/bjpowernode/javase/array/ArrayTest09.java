package com.bjpowernode.javase.array;
/*
关于java中的二维数组
    1、二维数组其实就是一个特殊的一维数组
        特殊在这个一维数组当中的每一个元素都是一个一维数组。
    2、三维数组是什么？特殊在一个数组中每一个元素都是二维数组
    3、二维数组静态初始化
        int[][] array = {{1,1,1},{3,2},{4,5,6}};
 */
public class ArrayTest09 {
    public static void main(String[] args) {
        //一维数组
        int[] array = {100,200,300};
        System.out.println(array.length);//3
        //二维数组,里面是四个一维数组
        int[][] a = {
                {100,200,300},
                {30,20,40,50},
                {6,7,9,1},
                {0}};
        System.out.println(a.length);//4
        System.out.println(a[0].length);//3,因为它是一个一维数组，所以能.lenght
        System.out.println(a[1].length);//4
    }
}
