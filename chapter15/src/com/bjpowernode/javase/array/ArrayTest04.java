package com.bjpowernode.javase.array;
//当一个方法的参数是一个数组时，我们还可以采用这种方法传
public class ArrayTest04 {
    public static void main(String[] args) {
        //静态初始化一维数组
        int[] a ={1,2,3};
        printArray(a);
        //动态初始化一维数组
        System.out.println("==============");
       // printArray({1,2,3});没有这种语法
        printArray(new int[]{1,2,3});//如果传静态数组，必须需要这样写！！！【】没有数字
        int[] a2 = new int[4];
        printArray(a2);

        System.out.println("================");
        printArray(new int[3]);//直接传参时写动态数组
    }
    public static void printArray(int[] array){
        for(int i = 0;i < array.length;i++){
            System.out.println(array[i]);
        }
    }
}
