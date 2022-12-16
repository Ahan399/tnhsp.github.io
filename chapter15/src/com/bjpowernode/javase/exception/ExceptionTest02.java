package com.bjpowernode.javase.exception;

public class ExceptionTest02 {
    public static void main(String[] args) {
        //通过“异常类”实例化"对异常象"
        NumberFormatException nfe = new NumberFormatException("数字格式化异常!!");
        System.out.println(nfe);

        NullPointerException npe = new NullPointerException("空指针异常发生了！");

    }
}
