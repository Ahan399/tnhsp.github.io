package com.bjpowernode.javase.array;

public class ArrayTest11 {
    public static void main(String[] args) {
        String[][] array = {
                {"java","oracle","c++","python","c#"},
                {"张三","李四","王五"},
                {"lucy","jack","rose"}
        };

        //遍历二维数组：
            for(int i=0;i < array.length;i++){//外层循环三次
                //内存循环负责输出一行
                for(int j=0;j<array[i].length;j++){
                    System.out.println(array[i][j]);
                }
                System.out.println();//换行
            }
    }
}
