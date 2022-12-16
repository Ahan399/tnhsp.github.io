package com.bjpowernode.javase.array;
/*
关于二维数组中元素的读和改
    a[二维数组的一维数组的下标][一维数组的下标]
 */
public class ArrayTest10 {
    public static void main(String[] args) {
        int[][] a = {
                {34,4,65},
                {100,200,300,111},
                {0}
        };

        //请取出以上二维数组中的第一个一维数组的第一个元素
        int[] a0 = a[0];
        int x = a0[0];
        System.out.println(x);

        System.out.println(a[0][0]);//根据以上代码，可合并为这种写法

        //改
        a[2][0]=11110;//把100改成了11110
    }

}
