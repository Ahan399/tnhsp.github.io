package com.bjpowernode.javase.array;

/**
 * 动态初始化二维数组
 */
public class ArrayTest12 {
    public static void main(String[] args) {
        //三行四列
        //3个一维数组，每一个一维数组当中4个元素
        int[][] array = new int[3][4];
        int[][] a = {
                {1,2,3,4},
                {4,5,6,56},
                {11,24,16}
        };

        printArray(a);
        printArray(new int[][]{{1,2,3,4},{4,5,6},{7,8,9,10}});//也可以这样写
    }
    public static void printArray(int[][] array){
        for(int i =0;i< array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.println(array[i][j]);
            }
            System.out.println();
        }
    }

}
