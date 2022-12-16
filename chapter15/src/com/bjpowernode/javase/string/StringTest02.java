package com.bjpowernode.javase.string;

public class StringTest02 {
    public static void main(String[] args) {
        String s1 ="hello";
        String s2 ="hello";
        //双等号保存的是不是比较内存地址？是！所以是ture，都指向同一个方法区位置
        System.out.println(s1==s2);
        String x =new String("xyz");
        String y =new String("xyz");
        //此时非常特别！
        //此时是false，因为x,y的内存地址指向堆中创建的对象，堆中对象的指向地址才是方法区字符串常量池！
        System.out.println(x==y);
        //通过这个案例学习，我们知道了字符串对象之间比较不能使用“==”
        //"=="不保险！ 需要用到sun公司已经重写过的 .equals() 比较字面量区别！
        System.out.println(x.equals(y));

        String k = new String("testString");
        //为什么“字符串“可以调用方法，因为它也是一个对象（前提是字符串常量方法区里有它）
        System.out.println("testString".equals(k));//存在空指针异常的风险，不建议这样写
    }
}
