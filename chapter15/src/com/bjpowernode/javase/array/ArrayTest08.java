package com.bjpowernode.javase.array;

/**
 * 关于一维数组扩容
 * 在java开发中，数组长度一旦确定不可变，那么数组满了怎么办？
 *
 *      java中对数组的扩容是：
 *          先新建一个大容量的数组，然后将小容量数组中的数据一个一个拷贝到大数组当中。
 *
 *      结论：数组扩容效率较低，因为涉及拷贝的问题。所以在以后开发中注意尽可能少用拷贝
 */
public class ArrayTest08 {
    public static void main(String[] args) {
        //System.arraycopy(五个参数);//静态的拷贝函数
        //拷贝源
        int[] src = {1,11,22,3,4};
        //拷贝目标（大数组）
        int[] dest = new int[20];//初始化一个长度20的数组，每个元素默认值0
        System.arraycopy(src,1,dest,3,2);
        //从src数组的1位置开始，延申两个元素，拷贝到dest数组的的3位置开始
        for(int i =0;i< dest.length;i++){
            System.out.println(dest[i]);
        }
        //System.arraycopy(src,0,dest,0,src.length);  //将src从第一位起全部拷贝过去
        Object[] objs = {new Object(),new Object(),new Object()};
        Object[] newObjs = new Object[10];
        //实际上这里拷贝的时候还是拷贝对象的地址而已，需要重写toString
        System.arraycopy(objs,0,newObjs,0,objs.length);
        for(int i =0;i< newObjs.length;i++){
            System.out.println(newObjs[i]);
        }
    }
}
