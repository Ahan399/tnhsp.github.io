package com.bjpowernode.jdbctest;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC的另一种注册驱动方式
 */
public class JDBCTest03 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "0000";
        try {
            //1 注册驱动
           //DriverManager.registerDriver(new Driver());
            //注册驱动的第二种方式，因为Driver内有个静态代码块写好了注册驱动，类加载就开始启动
            Class.forName("com.mysql.jdbc.Driver");

            //2 获取连接
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);


        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

