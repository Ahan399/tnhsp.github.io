package com.bjpowernode.javase.array;
//当一个方法上参数类型是数组的话
public class ArrayTest03 {
    //main 方法的编写格式也可以采用C++的语法格式哦！
    public static void main(String[] args) {
        //调用方法传一个数组
        int[] x ={1,2,3,4};
        printArray(x);
        String[] strs = {"abc","efg","hehe","haha"};
        printArray(strs);//方法重载
    }
    public static void printArray(int[] array){
        for(int i = 0;i< array.length;i++){
            System.out.println("整型数组中的元素："+array[i]);
        }
    }
    public static void printArray(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("字符串数组中的元素:"+args[i]);
        }
    }
}
