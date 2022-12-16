package com.bjpowernode.homework;
/*
物资运输机，只能移动不能攻击
 */
public class WuZiFeiJi extends Weapon implements Moveable{
    @Override
    public void move() {
        System.out.println("飞机在起飞");
    }
}
