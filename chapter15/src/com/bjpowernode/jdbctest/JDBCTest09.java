package com.bjpowernode.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 PreparedStaement完成增删改
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC","root","0000");


            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
           ps = conn.prepareStatement(sql);

            ps.setInt(1,60);
            ps.setString(2,"xiaoshoubu");
            ps.setString(3,"shanghai");

            int count = ps.executeUpdate();
            System.out.println(count);

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
