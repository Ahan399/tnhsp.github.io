package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
处理异常的第一种方式：在方式声明位置使用thorows
 */
public class ExceptionTest06 {
    public static void main(String[] args) {
        //不推荐main上在上抛异常，因为最终也会抛到JVM，编译失败
        System.out.println("main begin");
        try {
            //尝试，没报错走此分支
            m1();
            System.out.println("成功执行！");
        }catch (IOException e){
            // e的引用地址就是那个new出来的异常对象的地址
            //catch是捕捉异常的分支
            //在catch中处理异常
            System.out.println("文件路径不存在");
        }

        System.out.println("main over");
    }

    private static void m1() throws IOException {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }
//throws IOException , ClassCastException 可以上抛多个异常
    private static void m2() throws IOException {
        System.out.println("m2 begin");
        //此时异常又被上抛给m2()
        //抛父类异常同样可以上抛
        m3();
        System.out.println("m2 over");
    }

    private static void m3() throws FileNotFoundException {
        //调用JDK 某个构造方法
        //这个类未接触过，后期IO流的知识
        //编译报错原因是？
        /*
        1.这里调用了一个构造方法
        2.这个构造方法声明位置上有thorws FileNotFoundException上抛给m3了
        3.通过类继承结构看到，FileNotFoundException父类是Exception
        4.这个异常并没有在m3()中解决
         */
        new FileInputStream("D:\\baiduDown\\dzx.txt");//创建一个输入流对象，该流指向一个字符串对象
        System.out.println("m3 end");
    }
}
