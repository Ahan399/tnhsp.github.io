package com.bjpowernode.javase.string;
//画出内存图
public class UserTest {
    public static void main(String[] args) {
        User user = new User(110,"张三");//堆中的user对象有一个String name的内存地址，指向了字符串常量池里的“张三”
    }
}
