package com.bjpowernode.javase.annotation7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {


}
//这个注解ID用于标记类，被标准的类中必须有一个int类型的ID属性，没有就报异常