package com.bjpowernode.javase.array;
/*
数组工具类，自己写的
    二分法查询程序
    例如：
        10(下标0),11,12,13,14,15,16,17,18,19,20(下标10) arr数组
        通过二分法找出18这个元素的下标：
            (0+10) / 2 -->中间元素的下标：5

           拿着中间这个元素和目标查找的元素进行对比：
            中间元素：arr[5] -->15
            15 < 18(被查找的元素)
            可得：被查找的元素18在目前中间元素15的右边
            所以开始元素的下标从0变为 5+1

            再重新计算一个中间元素的下标：
                开始下标：5+1
                结束下标：10
                (6 + 10 ) / 2 -->8 (中间元素下标)

                8下标对应的arr[8]是18
                    找到中间元素正好和被找元素18相等，此时查找完成

   ps:二分法查找算法需要基于排序的继承之上。（没有排序的数据是无法查找的)
 */
public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = {100,200,230,235,600,1000,2000,9999};
        //找出arr这个数组200的下标
        //调用方法
        int index = binarySearch2(arr,1000);
        System.out.println(index == -1?"该元素不存在":"该元素下标："+ index);
    }

    public static int binarySearch2(int[] arr, int dest) {
        //开始下标
        int begin = 0;
        int end = arr.length-1;

        //开始元素只要在结束下标的左边，就有机会继续循环
        // 当未return mid时，又不满足了while条件，证明这个元素不在这个数组里
        while (begin <= end) {
            int mid = (begin + end) / 2;//中间下标
            if (arr[mid] == dest) {
                //当中间下标和目标元素相等，结束循环的条件！
                return mid;
            } else if (arr[mid] < dest) {
                //目标在“中间”的右边
                //开始元素下标需要发生变化
                begin = mid + 1;
            } else if (arr[mid] > dest) {
                //目标在“中间”的左边
                //结束下标需要发生变化
                end = mid + 1;
            }

        }
        return -1;
    }
}

