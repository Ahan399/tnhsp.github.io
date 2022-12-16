package com.bjpowernode.javase.array;
/*
    当创建数组时，缺点数组存储哪些具体的元素时使用静态初始化
    当创建数组时，不确定具体存储哪些元素，预分配空间则用动态初始化
 */
public class ArrayTest02 {
    public static void main(String[] args) {
        //定义一个数组采用动态初始化方式
        int[] a = new int[4];//创建长度为4的int数组，每个元素默认值为0
        for(int i =0;i < a.length;i++){
            System.out.println("数组下标为"+i+"的元素是："+a[i]);
        }
        a[0] = 222;
        a[1] = 145;
        Object[] objs = new Object[3];//初始化一个长度3的object数组
        for(int i =0;i < objs.length;i++){
            System.out.println("数组下标为"+i+"的元素是："+objs[i]);
        }

        String[] strs = new String[3];
        for(int i =0;i < strs.length;i++){
            System.out.println("数组下标为"+i+"的元素是："+strs[i]);
        }
        Object[] objects = {new Object(),new Object(),new Object()};
        for(int i =0;i < objects.length;i++){
            System.out.println("静态定义objects数组下标为"+i+"的元素是："+objects[i]);
        }
    }
}
