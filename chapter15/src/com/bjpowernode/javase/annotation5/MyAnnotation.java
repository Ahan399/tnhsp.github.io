package com.bjpowernode.javase.annotation5;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//只允许该注解可以标准类、方法
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//希望这个注解可以被反射
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /*
    value属性
     */

    String value() default "guangzhou";
}
