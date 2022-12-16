package com.bjpowernode.jdbctest;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*

    如果解决SQL注入问题

        1、解决SQL注入问题
            只有用户提供的信息不参与SQL语句的编译过程
            即使用户提供的信息中含有SQL语句的关键字，但没有参与编译，不起作用
            要想用户信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
            PreparedStatement基础了Statement
            它属于预编译的数据库操作对象
            原理是：预先对SQL语句的框架进行编译，再给SQL语句传值
 */
public class JDBCTest07 {
    public static void main(String[] args) {
        //先初始化一个界面
        Map<String,String> userLoginInfo = initUi();
        //验证用户名和密码
        boolean loginSuceess = login(userLoginInfo);
        //最后登录结果
        System.out.println(loginSuceess?"登录成功":"登录失败");
    }

    /**
     * 如果为真，登录成功
     * 如果为假，登录失败
     * @param userLoginInfo
     * @return
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标机
        boolean loginSuccess = false;
        //JDBC代码
        Connection conn = null;
        PreparedStatement ps = null;//替换数据库操作对象
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "0000";

        String loginName = userLoginInfo.get("LoginName");
        String loginPwd = userLoginInfo.get("LoginPwd");

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接

            conn = DriverManager.getConnection(url,user,password);
            //3.获取预编译的数据库操作对象
            //sql语句框架，其中一个？标识一个占位符
            String sql = "select * from t_user where loginName = ?and loginPwd =?";// ?代表占位符
            ps = conn.prepareStatement(sql);
            //给占位符?传值
            //第一个问号，下标是1，第二个问号，下标是2...
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            //4.执行sql
            rs = ps.executeQuery();
            //5.处理结果集
            if(rs.next()){
                //结果集有数据证明查询到了
                loginSuccess=true;
                return loginSuccess;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return loginSuccess;

    }

    /**
     * 吃时候用户界面
     * @return 用户输入用户名和密码等登录信息
     */
    private static Map<String,String> initUi() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String LoginName = s.nextLine();
        System.out.println("密码：");
        String LoginPwd = s.nextLine();
        Map<String,String> useLoginMap = new HashMap<>();
        useLoginMap.put("LoginName",LoginName);
        useLoginMap.put("LoginPwd",LoginPwd);
        return useLoginMap;


    }

}
