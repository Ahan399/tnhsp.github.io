package com.bjpowernode.javase.number;

import java.util.Random;

public class RandomTest01 {
    public static void main(String[] args) {
        Random random = new Random();
        //随机产生一个int取值范围内的随机数
        int num1 = random.nextInt();
        System.out.println(num1);

        //产生0~100之间的随机数
        //nextInt翻译为：下一个int类型的数据是101，表示只能到100
        int num2 = random.nextInt(101);
        System.out.println(num2);
    }
}
