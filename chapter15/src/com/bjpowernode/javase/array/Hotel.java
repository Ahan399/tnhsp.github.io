package com.bjpowernode.javase.array;
/*
酒店对象：酒店中有二维数组，数组中有Room对象
 */
public class Hotel {
    //酒店名字
    private String name;
    /*
    二维数组，模拟大厦所有房间
     */
    private Room[][] rooms;

    //通过构造方法盖楼

    public Hotel() {
        //一共有几层，每层的房间类型是什么，每个房间的编号是什么？
        //我们可以先写死。一层单人间，二层标准间，三层总统套房.每层10个房间
        /*
        房间编号
        1楼：101、102、103、104、105、106
        2楼：201、202、203
        3楼：301、302、303

         */
        rooms = new Room[3][10];//三行十列，动态初始化空间，此时只是null

        //创建30个Room对象，放到数组当中
        //怎么放？ room[0][1] = new Room();
        //二维数组遍历呀！
        for(int i=0;i < rooms.length;i++){
            //i是编号。要用i+1是楼层
            for(int j=0;j < rooms[i].length;j++){
                if(i==0) {
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "单人间", true);
                }else if(i == 1){
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "标准间", true);
                }else if(i == 2){
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "总统套房", true);
                }
            }
        }
    }

    //在酒店对象中提供一个打印房间列表的方法
    public void print(){
        //遍历rooms二维数组
        for(int i=0;i < rooms.length;i++){
            for (int j=0;j < rooms[i].length;j++){
                Room room = rooms[i][j];
                System.out.println(room);
            }
            //换行
            System.out.println();
        }
    }
    /*
    订房方法
    使用此方法时需要传递一个房间编号过来。这个房间编号是前台小姐姐输入的
     */
    public void order(int roomNo){
        //订房最主要的是将房间对象的status修改为false
        //Room对象的status修改为false
        //通过房间编号算出二维数组下标
        Room room = rooms[roomNo /100 -1][roomNo%100 -1];
        room.setStatus(false);
        System.out.println(roomNo+"已订房");
    }
    //退房方法
    public void exit(int roomNo){
        Room room = rooms[roomNo /100 -1][roomNo%100 -1];
        room.setStatus(true);
        System.out.println(roomNo+"已退房");
    }
}
