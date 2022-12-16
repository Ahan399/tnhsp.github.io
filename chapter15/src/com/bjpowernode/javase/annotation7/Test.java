package com.bjpowernode.javase.annotation7;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception{

        Class userClass = Class.forName("com.bjpowernode.javase.annotation7.User");
        boolean isOk = false;
        if(userClass.isAnnotationPresent(Id.class)){
            //当一个类上面有ID注解的时候，要求类中必须存在INT类型的id属性
            //如果没有int类型的id属性则报异常
            Field[] fields = userClass.getDeclaredFields();

            for (Field field: fields) {
                if ("id".equals(field.getName()) &&
                        "int".equals(field.getType().getSimpleName())){
                    //符合条件表示是合法的类
                   isOk = true;
                   break;//已经找到合法属性了，不用循环了再找属性了
                }

            }
            //判断是否合法
            if(!isOk){
                throw new HasnotIdPropertyException("被@Id注解的类必须有一个int类型的id属性");
            }
        }
    }
}
