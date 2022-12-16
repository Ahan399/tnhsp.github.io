package com.bjpowernode.javase.integer;
/*
    java中为8种基本数据类型又对应准备了8种包装类型。8种包装类属于引用数据类型
 */
public class IntegerTest01 {
    public static void main(String[] args) {
        int x = 123;
        //doSome虽然不能传123，但可以传入一个100对应的包装类型
        doSome(x);
    }

    public static void doSome(Object obj){
        System.out.println(obj);
    }
}
