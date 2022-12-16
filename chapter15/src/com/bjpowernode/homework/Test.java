package com.bjpowernode.homework;

public class Test {
    public static void main(String[] args) {
        Army army = new Army(4);
        //创建武器对象
        Fighter fighter1 = new Fighter();
        Fighter fighter2 = new Fighter();
        Tank tank = new Tank();
        WuZiFeiJi wuzifeji = new WuZiFeiJi();
        GaoShePao gaoshepao = new GaoShePao();
        //添加武器
        try {
            army.addWeapon(fighter1);
            army.addWeapon(gaoshepao);
            army.addWeapon(tank);
            army.addWeapon(wuzifeji);
            army.addWeapon(fighter2);
        }catch (AddWeaponException e){
            System.out.println(e.getMessage());
        }
        army.moveAll();
        army.attackAll();
    }

}
