package com.bjpowernode.javase.array;

import java.util.Arrays;

/*
使用一下sun公司提供的数组工具类：java.util.Arrays
 */
public class ArraysTest01 {
    public static void main(String[] args) {
        int[] arr = {112,3,4,56,67,1};
        Arrays.sort(arr);//数组排序方法
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
