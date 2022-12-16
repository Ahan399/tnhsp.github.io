package com.bjpowernode.javase.array;

import java.util.Scanner;

/*
为某个酒店编写程序：酒店管理系统、模拟订房、退房、打印所有房间状态等功能
    1.该系统的用户是：酒店前台
    2.酒店使用一个二维数组来模拟。"Room[][] rooms;"
    3.酒店中的每一个房间应该是一个java对象：Room
    4. 每一个房间Room应该有:房间编号、房间类型、房间是否空闲
    5.系统应该对外提供的功能：
        可以预定房间：用户输入房间编号，订房。
        可以退房：用户输入房间编号、退房
        可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。
 */
public class HotelMgSystem {
    public static void main(String[] args) {
        /*Room room = new Room(101,"单人间",false);
        System.out.println(room);*/

        /*Room room1 = new Room(101,"单人间",false);
        Room room2 = new Room(102,"单人间",false);
        System.out.println(room1.equals(room2));*/
        Hotel hotel = new Hotel();
        System.out.println("欢迎使用酒店管理系统，请认真阅读以下使用说明");
        System.out.println("请输入对应的功能编号：【1】表示查看房间列表。");
        System.out.println("请输入对应的功能编号：【2】表示订房间。");
        System.out.println("请输入对应的功能编号：【3】表示退房间。");
        System.out.println("请输入对应的功能编号：【0】表示退出系统。");
        while (true) {
            Scanner s = new Scanner(System.in);//创建一个输入输出对象s
            System.out.println("请输入功能编号:");
            int i = s.nextInt();//此时用户等待输入
            if (i == 1) {
                //打印
                hotel.print();
            } else if (i == 2) {
                //订房
                System.out.println("请输入房间编号");
                int roomNo = s.nextInt();
                hotel.order(roomNo);
            } else if (i == 3) {
                //退房
                System.out.println("请输入房间编号");
                int roomNo = s.nextInt();
                hotel.exit(roomNo);
            } else if (i == 0) {
                //退出系统
                System.out.println("再见，欢迎下次使用！");
                return;//退出主程序
            } else {
                //出错了！
                System.out.println("输入功能编号有误，请重新输入！");
            }
        }
        //创建酒店对象
       /* Hotel hotel = new Hotel();
        hotel.order(202);
        hotel.print();*/

    }
}
