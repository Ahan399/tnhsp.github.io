package com.bjpowernode.javase.danlianbiao;

public class Test {
    public static void main(String[] args) {
        Link link = new Link();
        link.add("abc");
        link.add("def");
        link.add("xyz");
        System.out.println(link.size());
    }
}
