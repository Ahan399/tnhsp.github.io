package com.bjpowernode.javase.bean;

import java.io.Serializable;

public class Student2 implements Serializable {
    private static final long serialVersionUID = 4326928230855776970L;
    /*private static final long serialVersionUID = -1L;*/
    private int no;
    private String name;

    public Student2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Student2() {
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
        return "Student2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
