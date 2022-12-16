package com.bjpowernode.javase.number;

import java.util.Arrays;
import java.util.Random;

public class RandomTest02 {
    public static void main(String[] args) {
        //创建random对象
        Random random = new Random();
        int[] arr = new int[5];//动态初始化，默认值是0
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = -1;
        }
        //循环生成随机数
        int index =0;
        while(index < arr.length){
            int num = random.nextInt(6);//生成一个0~100的int
            //判断arr数值中有没有这个num
            //如果没有num则放进去
            if(!contains(arr,num)){
                arr[index] = num;
                index++;
            }
        }
        for(int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static boolean contains(int[] arr,int key){
        /*
        //这个方案有bug 排序出问题了
            Arrays.sort(arr);
            //二分法查找，找到返回数组下标，没找到返回-1
            return Arrays.binarySearch(arr,key) >=0;
        */
        for(int i=0;i<arr.length;i++){
           if(arr[i] == key){
               return true;
           }

        }
        return false;
    }
}
