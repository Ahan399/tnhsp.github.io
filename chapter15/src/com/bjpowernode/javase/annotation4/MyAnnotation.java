package com.bjpowernode.javase.annotation4;
/*
注解当中的属性可以是哪一种类型

 */
public @interface MyAnnotation {
    int value1();
    String value2();
    int[] value3();
    String[] value4();
    Season value5();
    Season[] value6();
    Class parameterType();
    Class[] parameterTypes();
}
