package com.bjpowernode.javase.enum2;
/*
采用枚举方式改造程序
 */
public class EnumTest02 {
    public static void main(String[] args) {
        Result r = divide(10,0);
        System.out.println(r == Result.SUCCESS?"计算成功":"计算失败");
    }
    /*
    计算商，返回Result.SUCCESS成功，Result.FAIL失败
     */
    public static Result divide(int a,int b){
        try{
            int c = a / b;
            return Result.SUCCESS;
        }catch (Exception e){
            return Result.FAIL;
        }
    }
    /*
    枚举中的每一个值可以看作是常量
     */
 enum Result{
     //SUCCESS是枚举Result类型中的一个值，它们是一个常量
       SUCCESS,FAIL
 }
}
