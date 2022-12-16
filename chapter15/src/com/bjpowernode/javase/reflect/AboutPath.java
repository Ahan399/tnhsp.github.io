package com.bjpowernode.javase.reflect;

import java.io.FileReader;

/*
研究一下关于文件路径的问题
 */
public class AboutPath {
    public static void main(String[] args) throws Exception{
        //当程序移植到了另一个路径时，就需要修改以下这段代码的路径了
        //以下代码离开了IDEA，换到了其他为止，可能当下路径就无效了
        /*FileReader reader = new FileReader("classinfo.properties");
        */
        //接下来说一种比较通用的一种路径，即使代码换位置了，这样编写任然是通用的
        //注意使用以下通用方式的前提是：你这个文件必须在类路径下
        //什么是类路径下？凡是在src下的都是类路径下【记住】

        /*
        解释以下代码：
            Thread.currentThread() 当前线程对象
            getContextClassLoader() 是线程对象的方法，可以获得当前线程的类加载器对象
            getResource() 【加载资源】是类加载器对象的方法，当前线程的类加载器默认从类的根路径（src）下加载资源
            getPath() 获取对象的绝对路径
         */
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("classinfo.properties").getPath();
        //采用以上方法就获取到配置文件的绝对路径了
        System.out.println(path);

        String path2 = Thread.currentThread().getContextClassLoader()
                .getResource("com/bjpowernode/javase/reflect/db.properties").getPath();

        System.out.println(path2);
    }
}
