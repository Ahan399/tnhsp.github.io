package com.bjpowernode.javase.stringbuffer;

/**
 * 线程不安全
 */
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //用StringBuilder也能完成字符串拼接
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("world");
        sb.append(520);
    }
}
