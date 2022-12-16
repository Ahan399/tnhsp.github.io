package com.bjpowernode.javase.array;
/*
    一维数组：数组中存储的类型为：引用类型
    对于数组来说，实际上只能存储java对象的“内存地址”。
 */
public class ArrayTest07 {
    public static void main(String[] args) {
        //创建一个Animal类型数组
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1,a2};

        //对Animal数组进行遍历
        for(int i=0;i< animals.length;i++){
           // Animal a = animals[i];
            //a.move();
            animals[i].move();
        }
        //动态初始化一个Animal数组
        Animal[] ans = new Animal[2];
        //创建一个Animal对象，放到第一个数组盒子中
        ans[0]= new Animal();
        //ans[1]= new Product(); 不允许的，因为数组定义时是Animal类型的

        ans[1]= new Cat();//Animal数组中可以存放CAT类型数据，因为Cat是一个Animal

        //此处创建一个Animal类型数组，存放CAT和BIRD
        Animal[] anis = {new Cat(),new Bird()};
        for(int i =0;i< anis.length;i++){
           // Cat cc = anis[i]; 会报错,因为你不确定取出的是CAT还是Bird!
           // anis[i]取出来的可能是bird，可能是CAT,不过肯定是Animal
            Animal an = anis[i];
            an.move();
            //调用对象特有方法，父类无法调用，需要判断转型
            if(anis[i] instanceof Cat){
                Cat cat = (Cat)anis[i];
                cat.catchMouse();
            }else if(anis[i] instanceof Bird){
                Bird bird = (Bird)anis[i];
                bird.sing();
            }
        }
    }
}
class Animal{
    public void move(){
        System.out.println("Animal move...");
    }
}
//商品类
class Product{

}
//CAT是子类
class Cat extends Animal{
    public void move(){
        System.out.println("猫在走猫步");
    }
    //写一个猫的特有方法
    public void catchMouse(){
        System.out.println("猫在抓老鼠！");
    }
}
class Bird extends Animal{
    public void move(){
        System.out.println("鸟在飞");
    }
    public void sing(){
        System.out.println("鸟儿在歌唱");
    }
}
