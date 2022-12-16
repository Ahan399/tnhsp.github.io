package com.bjpowernode.javase.number;

import java.math.BigDecimal;

/*
1.BigDecimal 属于大数据，不属于基本数据类型，属于Java对象，常用于财务软件
 */
public class BigDecimalTest01 {
    public static void main(String[] args) {
        BigDecimal v1 = new BigDecimal(100);
        BigDecimal v2 = new BigDecimal(200);
        //求和
        //v1 + v2 不可以使用，因为它是引用数据类型
        BigDecimal v3 = v1.add(v2);
    }
}
