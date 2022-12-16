package com.bjpowernode.jdbctest;

import java.sql.*;
import java.util.Scanner;

/*
用户在控制台输入desc就是降序，输入asc就是升序
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc,desc表示降序,asc表示升序");
        System.out.println("请输入");
        String keyWords = s.nextLine();
        //执行sql
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC","root","0000");
            String sql = "select ename from emp order by ename "+keyWords;

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
