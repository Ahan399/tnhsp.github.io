package com.bjpowernode.jdbctest;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest01 {
    public static void main(String[] args) {

        Driver diver = null;
        try {
            diver = new com.mysql.jdbc.Driver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
