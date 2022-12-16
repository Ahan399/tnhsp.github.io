package com.bjpowernode.jdbctest.utils;

import java.sql.*;

/*

工具类，简化JDBC编程
 */
public class DBUtil {

    /*
    工具类的构造方法都是私有的
    不需要new对象
     */
    private DBUtil(){
    }
    //静态代码块在类加载时执行，只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return 连接对象
     * @throws SQLException
     */
    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC","root","0000");
    }

    /**
     * 释放对象方法
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
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
