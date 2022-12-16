package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/*
测试contains方法
 */
public class CollectionTest05 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //创建用户对象
        User u1 = new User("jack");
        User u2 = new User("jack");
        c.add(u1);
        //没重写equals前是false
        System.out.println(c.contains(u2));//false
        Collection cc = new ArrayList();

        String s1 = new String("hello");
        cc.add(s1);
        String s2 = new String("hello");
        cc.remove(s2);
        System.out.println(cc.size());//0
    }
}
class User{
    //没重写equals方法！
    private String name;
    public User(){}
    public User(String name){
        this.name = name;
    }
    //

    @Override
    public boolean equals(Object o) {
        if(o == null ||!(o instanceof User)) return false;
        if (this == o) return true;
       User u = (User)o;
        return u.name.equals(this.name);
    }


}