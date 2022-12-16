package com.bjpowernode.homework;
/*
战斗机，可移动可攻击的武器
 */
public class Fighter extends Weapon implements Moveable,Shootable{

    @Override
    public void move() {
        System.out.println("战斗机起飞");
    }

    @Override
    public void shoot() {
        System.out.println("战斗机开炮");
    }
}
