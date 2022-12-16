package com.bjpowernode.jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ResourceBundle bundle = ResourceBundle.getBundle("com/bjpowernode/jdbctest/test04");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        try{
            //1、注册驱动
            Class.forName(driver);
            //2、获取连接
            conn = DriverManager.getConnection(url,user,password);
            //3、获取数据库操作地形
            stmt = conn.createStatement();

            //4、执行sql
            String sql = "select empno,ename,sal from emp";
            rs = stmt.executeQuery(sql);
            //5、处理查询结果集

           while (rs.next()) {
               //标识光标指向的行有数据
               //不管数据中的数据类型是什么，都以String的形式取出
               //以下程序的1，2，3说的是第几列
               String empno = rs.getString("empno");//jdbc所有下标从1开始，这个标识这行第一个
               String ename = rs.getString("ename");
               String sal = rs.getString("sal");
               System.out.println(empno + "," + ename + "," + sal);

           }
            }catch (Exception e){
           e.printStackTrace();
        }finally {
            //6、释放资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
