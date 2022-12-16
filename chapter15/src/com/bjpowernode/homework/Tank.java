package com.bjpowernode.homework;
/*
坦克是武器，可移动可射击
 */
public class Tank extends Weapon implements Moveable,Shootable{
    @Override
    public void move() {
        System.out.println("坦克移动");
    }

    @Override
    public void shoot() {
        System.out.println("坦克开炮");
    }
}
