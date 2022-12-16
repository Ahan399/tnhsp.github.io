package com.bjpowernode.jdbctest;

import com.bjpowernode.jdbctest.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/*
测试写的DBUtil是否好用
    测试一下程序如何模糊查询
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "select ename from emp where ename like ?";
            ps = conn.prepareStatement(sql);
            //模糊查询ename第二个符合为A的信息，？的值写模糊查询的条件
            ps.setString(1,"_A%");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
