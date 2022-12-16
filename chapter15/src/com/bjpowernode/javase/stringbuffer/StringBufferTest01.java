package com.bjpowernode.javase.stringbuffer;
/*
    如果再实际开发中，对字符串频繁拼接，就会产生很多新的字符串
    字符串都再“字符串常量池”中,占用大量方法区内存
 */
public class StringBufferTest01 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        //以后拼接字符串，统一使用追加append()方法,使用传统+拼接会产生多个字符串常量，故不使用！
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("d");//append（）时添加字符串，检查其长度，会自动扩容数组，确保不溢出
        stringBuffer.append(3.14);
        stringBuffer.append(true);
        System.out.println(stringBuffer);

        StringBuffer sb = new StringBuffer(100);//指定初始容量为100的字符串缓存区对象
        sb.append("hello");
        sb.append("world");
        sb.append("hello");
        sb.append("kitty");
        sb.append(123);
        System.out.println(sb);
    }
}
