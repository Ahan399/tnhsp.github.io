package com.bjpowernode.javase.number;

import java.text.DecimalFormat;

public class DecimalFormatTest01 {
    public static void main(String[] args) {
        //表示加上千分位，保留两位小数
        DecimalFormat df = new DecimalFormat("###,###.##");
        String s = df.format(1234.56123);
        System.out.println(s);
        DecimalFormat df2 = new DecimalFormat("###,###.0000");
        String s2 = df2.format(1234789.11);
        System.out.println(s2);
    }
}
