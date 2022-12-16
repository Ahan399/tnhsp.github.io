package com.bjpowernode.javase.annotation;
/*
1、注解，或者叫做注释，英文单词是：Annotation
2、注解Annotation是一种引用数据类型。编译之后也是生成xxx.class文件
3、怎么自定义注解呢？语法格式？
    [修饰符列表] @interface 注解类型名{

    }
 */
public class AnnotationTest01 {
    @MyAnnotation
    private int no;

    @MyAnnotation
    public AnnotationTest01() {
    }

    public static void m1(){
        @MyAnnotation
        int i =100;
    }
    public void m2(){

    }
}
@MyAnnotation
interface MyInterface{

}
@MyAnnotation
enum Season{
    SPRING,SUNNY,FUCK
}
