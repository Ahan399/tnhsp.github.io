package com.bjpowernode.javase.array;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(new Object());//压栈进一个Object
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());//满了，栈帧已处于最大值[9]
        stack.push(new Object());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
       // System.out.println("取出的元素为："+stack.pop());
    }
}
