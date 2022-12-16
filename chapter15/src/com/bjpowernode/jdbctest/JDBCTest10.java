package com.bjpowernode.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
JDBC的事物机制

    1、JDBC的事物是自动提交的
        只有执行任意一条DML语句，就自动提交一次
        但在实际的业务当中，通常都是N条DML语句共同联合才能完成，必须
        保证他们这些DML语句在同一个事物中同时成功或者同时失败

     2、以下程序先来验证以下JDBC是否自动创建
 */
public class JDBCTest10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC","root","0000");


            String sql = "update dept set dname = ? where deptno = ?";
            ps = conn.prepareStatement(sql);


            ps.setString(1,"Xbumen");
            ps.setInt(2,30);
            int count = ps.executeUpdate();
            System.out.println(count);

            //重新给占位符传值
            ps.setString(1,"ybumen");
            ps.setInt(2,20);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
