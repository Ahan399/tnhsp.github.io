package com.bjpowernode.homework;
/*
高射炮，是武器，只能设计
 */
public class GaoShePao extends Weapon implements Shootable{
    @Override
    public void shoot() {
        System.out.println("开炮");
    }
}
