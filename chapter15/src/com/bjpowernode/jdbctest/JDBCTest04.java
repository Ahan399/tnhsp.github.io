package com.bjpowernode.jdbctest;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCTest04 {
    public static void main(String[] args) {

        //使用资源绑定器绑定配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("com/bjpowernode/jdbctest/test04");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;//连接通道对象
        Statement stmt = null;//数据库操作对象


        try {
            //1 注册驱动

            Class.forName(driver);
            //2 获取连接

            conn = DriverManager.getConnection(url,user,password);
            //3 获取数据库操作对象
            stmt = conn.createStatement();

            //4 执行SQL语句
            //String sql = "delete from dept where deptno = 40";
            String sql = "update dept set dname ='xiaoshoubu2',loc='tianjin2' where deptno = 20";
            int count = stmt.executeUpdate(sql);
            System.out.println(count ==1 ?"删除成功":"删除失败");

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
