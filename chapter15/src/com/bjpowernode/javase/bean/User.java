package com.bjpowernode.javase.bean;

import java.io.Serializable;

public class User implements Serializable {
    private int no;
    private String name;

    public User(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public User() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
