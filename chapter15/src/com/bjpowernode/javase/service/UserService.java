package com.bjpowernode.javase.service;
/*
用户业务类
 */
public class UserService {
    int no;
    int age;
    /*
    登录方法
     */
    public boolean login(String name,String password){
        if("admin".equals(name)&&"123".equals(password)){
            return true;
        }
        return false;
    }
    //可能还有一个同名login方法，区分方法依靠方法名和参数列表
    public void login(int i){

    }
    /*
    退出系统方法
     */

    public void logout(){
        System.out.println("系统已经安全退出！");
    }
}
