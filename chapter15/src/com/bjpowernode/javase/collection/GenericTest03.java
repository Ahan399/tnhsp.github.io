package com.bjpowernode.javase.collection;

public class GenericTest03<标识符随便写> {

    public void doSome(标识符随便写 o){

    }
    public static void main(String[] args) {
        GenericTest03<String> gt = new GenericTest03<>();
        gt.doSome("abc");
        GenericTest03<Integer> gt2 = new GenericTest03<>();
        gt2.doSome(123);
    }
}

