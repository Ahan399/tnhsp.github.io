package com.runoob.mysql;

import java.sql.*;

public class Con_mysql {

    static final String JDBC_DRIVER = "UI.mysql.jdbc.cj.Driver";
    static  final String DB_URL = "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("链接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ename,sal from emp";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                int sal = rs.getInt("sal");
                String ename = rs.getString("ename");

                System.out.print("ename"+ename);
                System.out.print("sal"+sal);
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(Exception se){

            se.printStackTrace();

        }catch(Exception e){

            e.printStackTrace();
        }finally{

            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
