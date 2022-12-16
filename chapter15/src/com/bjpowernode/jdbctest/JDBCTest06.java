package com.bjpowernode.jdbctest;

import java.sql.*;
import java.util.*;

/*
实现功能：
    1、需求：模拟用户登录功能实现
    2、业务描述：提供一个输入的入口，可以让用户输入用户名和密码
    用户输入用户名和密码之后，Java收集到用户信息
    java程序连接数据库验证用户名和密码是否合法
    合法：显示登录成功
    不合法：显示登录失败
    3、数据的准备
        在实际开发中，表的设计会使用专业的建模工具，我们这里安装一个建模工具PowerDesigner

    4、程序存在的问题
        用户名：
            fdsa
        密码：
            fdsa' or '1'='1

           这样居然也能登录成功！

           这种BUG情况被称为SQL注入
 */
public class JDBCTest06 {
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
        Statement stmt = null;
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
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql
            String sql = "select * from t_user where loginName = '"+loginName+"'and loginPwd ='"+loginPwd+"'";
            //以上正好完成了sql语句的拼接，以下代码语句给DBMS，DBMS进行sql编译
            //正好将用户提供的”非法信息“编译进去，导致原sql语句的含义被扭曲了

            rs = stmt.executeQuery(sql);
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
            if (stmt != null){
                try {
                    stmt.close();
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
