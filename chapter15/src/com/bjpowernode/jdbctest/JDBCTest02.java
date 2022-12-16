package com.bjpowernode.jdbctest;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;//连接通道对象
        Statement stmt = null;//数据库操作对象

        String url = "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "0000";
        try {
            //1 注册驱动
            DriverManager.registerDriver(new Driver());
            //2 获取连接
            conn = DriverManager.getConnection(url,user,password);
            //3 获取数据库操作对象
            stmt = conn.createStatement();

            //4 执行SQL语句
            //String sql = "delete from dept where deptno = 40";
            String sql = "update dept set dname ='xiaoshoubu',loc='tianjin' where deptno = 20";
            int count = stmt.executeUpdate(sql);
            System.out.println(count ==1 ?"删除成功":"删除失败");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            //6、释放资源
            if(conn != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
