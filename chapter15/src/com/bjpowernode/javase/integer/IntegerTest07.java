package com.bjpowernode.javase.integer;

public class IntegerTest07 {
    public static void main(String[] args) {
        int retValue = Integer.parseInt("123");//将字符串转换为int
        System.out.println(retValue + 100);
        int retValue1 = Integer.parseInt("不是数字");
        System.out.println(retValue1 +100);//产生异常了

        //了解内容
        
    }
}
