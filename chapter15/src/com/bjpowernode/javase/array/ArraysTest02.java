package com.bjpowernode.javase.array;

import java.util.Arrays;

public class ArraysTest02 {
    public static void main(String[] args) {
        // sun公司已写好Arrays工具类了，查看API文档使用
        int[] arr = {3,6,2,12,1,7,8,9};
        Arrays.sort(arr);//工具类的排序方法
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        int index = Arrays.binarySearch(arr,1);
        System.out.println(index >= 0?"该元素不存在":"该元素的下标是："+ index);
    }
}
