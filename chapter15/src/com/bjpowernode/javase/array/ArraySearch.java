package com.bjpowernode.javase.array;
/*
数组的元素查找
    数组元素查找有两种方式：
        第一种：一个一个挨着查找，查到找到位置
        第二种：二分法查找（算法），这个效率较高
 */
public class ArraySearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,87,9};

       /* for(int i=0;i<arr.length;i++){
            if(arr[i]== 87){
                System.out.println("87元素的下标是："+i);
                return;
            }
        }
        System.out.println("87元素未在数组中找到");*/
        //以上程序最好封装成一个方法
        //传一个数组，第二参数是要被查找的元素。
        //返回值：返回被查找这个元素的下标
        int index = arraySearch(arr,87);
        System.out.println(index ==-1 ?"该元素不存在":"该元素的下标是："+index);
    }
    /*
    从数组中检索某个元素的下标
    arr：被检索的数组
    ele：被检索的元素

     */
    public static int arraySearch(int[] arr, int ele) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]== ele){

                return i;
            }
        }
        return  -1;
    }
}
