package UI;
import javax.swing.*;
import java.sql.*;
public class UpdateSQL {

    String driver = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/dzx";//数据库URL地址
    Connection con = null;//登录许可证
    //ResultSet rs = null;
    Statement st = null;
    String sql = "";
    public UpdateSQL() {

    }

    public void InsertData(String name,String word,String address,String age,String telephone,String job){

        int x = Integer.parseInt(age);//强制类型转换
        int y = Integer.parseInt(telephone);
        System.out.println(y);

        sql="insert into user_main(name,word,address,age,telephone,job) value ('"+name+"','"+word+"','"+address+"',"+x+","+y+",'"+job+"')";
        //拼接插入数据SQL
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }
        try {
            con = DriverManager.getConnection(URL, "root", "0000");

            st = con.createStatement();

            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功！");
                JOptionPane.showMessageDialog(null, "注册成功！");
            }
            //rs=st.executeQuery(sql);
            System.out.println("Connect Successfull.");
            System.out.println("ok");
            //rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }

    }
    //修改老师发布者状态专用方法
    public void UpdataState(String ServerId ,int myid,String subject,String myjob){
        if("YES".equals(ServerId)){
            sql = "update user_teach_state set state='"+ServerId+"',subject='"+subject+"'where id = "+myid+"";//用于老师用发布服务，修改学科
        }else if("NO".equals(ServerId)){
            sql = "update user_teach_state set state='"+ServerId+"'where id = "+myid+"";//用于学生完成委托后修改老师状态为NO
        }
        else {
            int serverId = Integer.parseInt(ServerId);
            sql = "update user_teach_state set state=" + myid + " where id = " + serverId + "";//把我的ID改为服务者的状态，用于学生下单时
        }
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }
        try {
            con = DriverManager.getConnection(URL, "root", "0000");

            st = con.createStatement();

            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("修改数据成功！");
                JOptionPane.showMessageDialog(null, "执行成功！");
            }
            //rs=st.executeQuery(sql);
            System.out.println("Connect Successfull.");
            System.out.println("ok");
            //rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }

    }
}
