package com.bjpowernode.javase.array;

public class SelectSort {
    //选择排序具体实现
    public static void main(String[] args) {
        int[] arr ={3,1,6,2,5};
        //选择排序
        //5条数据序号4次（外层循环四次）
        for(int i=0;i<arr.length-1;i++){
            //i恰好是“参加比较的这堆数据中”最左边那个元素的下标
            //此下标的数据循环完一轮便不参与比较（最小值已在此下标数组元素下）
                //把小元素换到最左边的过程如下
                for(int j=i+1;j< arr.length;j++){
                    //关键，怎么找出一堆元素中最小的
                    //打擂台算法，每次两两比较留下最小值作擂主
                    //假设起始i下标元素是最小的
                    if(arr[j]<arr[i]){
                        //假如有比arr[i]还小的元素，把这个值赋给arr[i]
                        //如果没有则这次循环的arr[j]无需与它交换，进行下次循环找下一个元素打擂台
                        int temp = arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
        }
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
