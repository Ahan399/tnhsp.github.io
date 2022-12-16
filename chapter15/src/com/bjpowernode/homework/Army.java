package com.bjpowernode.homework;

public class Army {
    private Weapon[] weapons;//武器数组
    /*
    创建军队的构造方法，count武器数量
     */
    public Army(int count){
        weapons = new Weapon[count];
    }
    /*
    添加武器方法
     */
    public void addWeapon(Weapon weapon) throws AddWeaponException {
        for(int i=0;i< weapons.length;i++){
            if(null == weapons[i]){
                weapons[i] = weapon;
                System.out.println(weapon + "：武器添加成功！");
                return;///因为一次只加一个。跳出
            }
        }
        //执行到此处证明没添加成功，满了
        throw new AddWeaponException("武器数量已达到上限！");
    }
    /*
    所有可攻击武器攻击
     */
    public void attackAll(){
        for(int i=0;i< weapons.length;i++){
            if(weapons[i] instanceof Shootable){
                Shootable shootable = (Shootable)weapons[i];//向上转型
                shootable.shoot();
            }

        }
    }
    /*
    所有可移动武器移动
     */
    public void moveAll(){
        for(int i=0;i< weapons.length;i++){
            if(weapons[i] instanceof Moveable){
                Moveable moveable = (Moveable)weapons[i];//向上转型
                moveable.move();
            }

        }
    }
}
