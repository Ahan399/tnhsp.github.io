package com.bjpowernode.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
模拟转账业务

    sql脚本：
        drop table if exists t_act;
        create table t_act{
            actno int,
            balance double(7,2)
        };
        insert into t_act(actno,balance) values(111,20000);
        insert into t_act(actno,balance) values(222,0);
        commit;
        select * from t_act;
 */
public class JDBCTest11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC","root","0000");
            //将自动提交机制设定为手动提交
            conn.setAutoCommit(false);//开启事务

            String sql = "update t_act set balance = ? where actno = ?";
            ps = conn.prepareStatement(sql);


            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();

            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count += ps.executeUpdate();

            System.out.println(count ==2?"转账成功":"转账失败");
            //程序能走到此处，说明程序没有异常
            conn.commit();

        } catch (Exception e) {
            //回滚事务
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                   e1.printStackTrace();
                }
            }
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
