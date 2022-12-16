package com.bjpowernode.javase.array;

public class Room {
    /*
    房间编号
    1楼：101、102、103
    2楼：201、202、203
    3楼：301、302、303
     */

    private int no;
    /*
    房间类型:标准间、单人间、总统套房
     */
    private String type;
    //房间状态，是否空闲：true为空闲、false为占用
    private boolean status;

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    public Room() {
    }

    //set 和 get
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //boolean类型的get方法会叫is
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean equals(Object obj){
        if(obj == null|| !(obj instanceof Room)) return false;
        if(this == obj) return true;
        Room room = (Room)obj;
        return (this.no == room.getNo() && this.type.equals(room.getType()) && this.status == room.isStatus());
    }
    @Override
    public String toString() {
        return "["+no+","+type+","+(status?"空闲":"占用")+"]";
    }

}
