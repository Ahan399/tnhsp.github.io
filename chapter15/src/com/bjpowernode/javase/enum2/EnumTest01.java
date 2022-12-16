package com.bjpowernode.javase.enum2;
/*
分析以下程序在设计有什么缺陷？可编译可运行
这个案例未使用枚举


 */
public class EnumTest01 {
    public static void main(String[] args) {
        boolean success = divide(10,2);
        System.out.println(success);
        /*int retValue2 = divide(10,0);
        System.out.println(retValue2);*/
    }
    /*
    计算两个int数据类型的商,计算成功返回1，失败返回0
     */
    public static boolean divide(int a,int b){
        try {
            int c = a / b;//当b = 0不符合数学规则，会发生异常
            //执行到此处表示以上代码没有发生异常，表示执行成功！
            return true;
        }catch (Exception e){
            return false;
        }

    }
    /*
    使用这个方法设计boolean虽然好，但是在以后开发中可能需要返回三、四、五种结果情况，这时候就需要使用枚举了
     */
}
