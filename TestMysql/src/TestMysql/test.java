package TestMysql;

import java.sql.*;

public class test {public static void main(String[] args) {
    String driver = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/bjpowernode";//数据库URL地址
    Connection con = null;//登录许可证
    ResultSet rs = null;
    ResultSet rs2 = null;
    Statement st = null;
    Statement st2 = null;
    String sql = "select ENAME,JOB,SAL from emp";
    String sql2 = "insert into emp(EMPNO,ENAME,JOB,SAL) value ('7938','sam','fucker',1200)";
    try
    {
        Class.forName(driver);
    }
    catch(java.lang.ClassNotFoundException e)
    {
        System.out.println("Connect Successfull.");
        System.out.println("Cant't load Driver");
    }
    try
    {
        con=DriverManager.getConnection(URL,"root","");

        st=con.createStatement();
        st2=con.createStatement();
        int y = st2.executeUpdate(sql2);
        if(y>0){
            System.out.println("插入成功！");
        }
        rs=st.executeQuery(sql);//根据SQL获得结果

        if(rs!=null) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int countcols = rsmd.getColumnCount();//计算表有几个字段
            for(int i=1;i<=countcols;i++) {
                if(i>1) System.out.print(";");//显示隔开字段名
                System.out.print(rsmd.getColumnName(i)+" ");//输出顶端的字段名们
            }
            System.out.println("");
            while(rs.next()) {

                System.out.print(rs.getString("ENAME")+"  ");
                System.out.print(rs.getString("JOB")+"  ");
                System.out.println(rs.getString("SAL")+"  ");
            }
        }

        System.out.println("Connect Successfull.");
        System.out.println("ok");
        rs.close();
        st.close();
        rs2.close();
        st2.close();
        con.close();

    }
    catch(Exception e)
    {
        System.out.println("Connect fail:" + e.getMessage());
    }
}

}
