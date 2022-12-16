package com.bjpowernode.javase.reflect;
/*
获取到Class，能干什么呢？
    通过CLASS的newInstance()方法来实例化对象
    注意newInstance()内部实际上调用的是类的无参数构造方法
 */
public class ReflectTest02 {
    public static void main(String[] args) {

        try {
            //通过反射机制，获取Class,通过Class来实例化对象
            Class c  = Class.forName("com.bjpowernode.javase.bean2.User");//c代表user类型
            //newInstance() 方法会调用User这个类的无参数构造方法，完成这个类的创建！
            //重点是newInstance() 方法调用的是无参构造，必须保证类的无参构造是存在的！
            Object obj = c.newInstance();//返回一个泛型OBJ
            System.out.println(obj);//com.bjpowernode.javase.bean2.User@568db2f2
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
