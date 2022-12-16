package UI;

import java.sql.*;

public class SelectSQL {
    String driver = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/dzx";//数据库URL地址
    Connection con = null;//登录许可证
    ResultSet rs = null;
    Statement st = null;
    String sql = "";
    int myid ;
    public SelectSQL(){

    }

    public boolean MatchAccount(String name,String word){

        boolean agress = false;
        String x=name;
        String y=word;

        sql = "SELECT name,word,id FROM user_main";
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("name")+"  ");
                    System.out.print(rs.getString("word")+"  ");
                    System.out.print(rs.getString("id")+"  ");
                    if(x.equals(rs.getString("name"))&&y.equals(rs.getString("word"))){
                        System.out.println("匹配账号成功");
                        agress = true;
                        myid=Integer.parseInt(rs.getString("id"));
                        System.out.println("我的账号ID为："+myid);
                        break;
                    }

                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }


        return agress;
    }
    public int getDatacount(){

        int count = 0;
        sql = "SELECT a.name,b.subject,a.address,a.telephone FROM user_main a join user_teach_state b on a.id = b.id where b.state = 'YES'";
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("name")+"  ");
                    System.out.print(rs.getString("subject")+"  ");
                    System.out.print(rs.getString("address")+"  ");
                    System.out.print(rs.getString("telephone")+"  ");
                    count++;


                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }



        return count;
    }
    public String SelectJob(int myid){
        String Myjob = "";
        sql = "SELECT name,job FROM user_main where id= "+myid+"";
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("name")+"  ");
                    System.out.print(rs.getString("job")+"  ");
                    Myjob = rs.getString("job");
                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }



        return Myjob;
    }
    public String SelectState(int myid){
        String pass = "";
        sql="SELECT state,id FROM user_teach_state WHERE id = "+myid+"";

        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("id")+"  ");
                    System.out.print(rs.getString("state")+"  ");
                    if("YES".equals(rs.getString("state"))){
                        pass = "YES";
                    }else{
                        pass = rs.getString("state");
                    }
                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }


        return pass;
    }
    public String getCustomerData(int myid,int whice,String Myjob){

        String customer = "";
        String address = "";
        String telephone = "";
        String CustomerData = "";
        String id = "";
        if("teacher".equals(Myjob)){
            sql = "SELECT * FROM user_main WHERE id = (SELECT state FROM user_teach_state where id = "+myid+") ";
        }else if("student".equals(Myjob)) {
            sql = "SELECT * FROM user_main WHERE id = (SELECT id FROM user_teach_state WHERE state = " + myid + ")";
        }
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("address")+"  ");
                    System.out.print(rs.getString("name")+"  ");
                    System.out.print(rs.getString("telephone")+"  ");
                    customer = rs.getString("name");
                    address =   rs.getString("address");
                    telephone =   rs.getString("telephone");
                    id =   rs.getString("id");
                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }
        //选择要那种信息？
        if(whice==0){
            CustomerData=customer;
        }else if(whice==1){
            CustomerData=address;
        }else if(whice==2) {
            CustomerData = telephone;
        }else if(whice==3){
            CustomerData = id;
            }
        return CustomerData;
    }
    public boolean whetherBuy(int myid){

        boolean exist = false;
        sql = "SELECT * FROM user_teach_state";
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }try
        {
            con= DriverManager.getConnection(URL,"root","0000");

            st=con.createStatement();
            rs=st.executeQuery(sql);//根据SQL获得结果
            if(rs!=null) {

                while(rs.next()) {

                    System.out.print(rs.getString("id")+"  ");
                    System.out.print(rs.getString("state")+"  ");
                    int teacherState = Integer.parseInt(rs.getString("state"));
                    if(myid == teacherState){
                        System.out.print("检测到用户已下单服务");
                          exist=true;
                          break;
                    }else{
                        System.out.print("检测到用户未下单服务");
                         exist=false;
                    }
                }

            }

            System.out.println("Connect Successfull.");
            System.out.println("ok");
            rs.close();
            st.close();
            con.close();

        }catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }

        return exist;
    }


}
