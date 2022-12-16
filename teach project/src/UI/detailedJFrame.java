package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class detailedJFrame extends JFrame{

    JLabel name_L = new JLabel("教师：");
    JLabel address_L = new JLabel("住址：");
    JLabel age_L = new JLabel("年龄：");
    JLabel telephone_L = new JLabel("电话号码：");
    JLabel jieshao_L = new JLabel("个人简介：");
    JLabel xueli_L = new JLabel("学历：");
    JLabel zhenshu_L = new JLabel("证书：");
    JLabel school_L = new JLabel("毕业学校：");

    JTextField name_T = new JTextField();
    JTextField address_T = new JTextField();
    JTextField age_T = new JTextField();
    JTextField telephone_T = new JTextField();
    JTextField jieshao_T = new JTextField();
    JTextField xueli_T = new JTextField();
    JTextField zhenshu_T = new JTextField();
    JTextField school_T = new JTextField();

    JButton enter = new JButton("下单");

    String name = "";
    String age = "";
    String address = "";
    String telephone = "";
    String jieshao ="";
    String xueli= "";
    String zhenshu= "";
    String school= "";


    public detailedJFrame(){

        this.setLayout(null);
        setTitle("--服务信息--");
        setSize(400,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        name_L.setHorizontalAlignment(SwingConstants.CENTER);//标签字体居中
        address_L.setHorizontalAlignment(SwingConstants.CENTER);
        age_L.setHorizontalAlignment(SwingConstants.CENTER);
        telephone_L.setHorizontalAlignment(SwingConstants.CENTER);
        jieshao_T.setHorizontalAlignment(SwingConstants.CENTER);
        xueli_T.setHorizontalAlignment(SwingConstants.CENTER);
        zhenshu_T.setHorizontalAlignment(SwingConstants.CENTER);
        school_T.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("隶书",Font.PLAIN,15);

        name_L.setFont(font);//应用画笔
        name_L.setForeground(Color.BLACK);
        address_L.setFont(font);
        address_L.setForeground(Color.BLACK);//设置标签字体大小颜色
        age_L.setFont(font);
        age_L.setForeground(Color.BLACK);//设置标签字体大小颜色
        telephone_L.setFont(font);
        telephone_L.setForeground(Color.BLACK);//设置标签字体大小颜色
        jieshao_L.setFont(font);
        jieshao_L.setForeground(Color.BLACK);
        xueli_L.setFont(font);
        xueli_L.setForeground(Color.BLACK);
        zhenshu_L.setFont(font);
        zhenshu_L.setForeground(Color.BLACK);
        school_L.setFont(font);
        school_L.setForeground(Color.BLACK);

        name_L.setBounds(0,10,80,80);
        age_L.setBounds(180,10,80,80);
        address_L.setBounds(0,40,80,80);
        telephone_L.setBounds(180,40,80,80);
        school_L.setBounds(5,70,80,80);
        xueli_L.setBounds(195,70,80,80);
        zhenshu_L.setBounds(10,100,80,80);
        jieshao_L.setBounds(10,130,80,80);

        enter.setBounds(320,220,60,40);

        this.add(name_L);
        this.add(address_L);
        this.add(age_L);
        this.add(telephone_L);
        this.add(jieshao_L);
        this.add(xueli_L);
        this.add(zhenshu_L);
        this.add(school_L);




    }
    public void addDetailData(String id,int myid,String subject){

        int iid = Integer.parseInt(id);//强制类型转换

        getDetailData(iid);//获得数据并赋值

        name_T.setText(name);
        name_T.setEnabled(false);
        name_T.setBounds(55,40,110,25);

        age_T.setText(age);
        age_T.setEnabled(false);
        age_T.setBounds(260,40,110,25);

        address_T.setText(address);
        address_T.setEnabled(false);
        address_T.setBounds(55,70,110,25);

        telephone_T.setText(telephone);
        telephone_T.setEnabled(false);
        telephone_T.setBounds(265,70,110,25);

        school_T.setText(school);
        school_T.setEnabled(false);
        school_T.setBounds(73,100,110,25);

        xueli_T.setText(xueli);
        xueli_T.setEnabled(false);
        xueli_T.setBounds(260,100,110,25);

        zhenshu_T.setText(zhenshu);
        zhenshu_T.setEnabled(false);
        zhenshu_T.setBounds(55,130,110,25);

        jieshao_T.setText(jieshao);
        jieshao_T.setEnabled(false);
        jieshao_T.setBounds(70,180,245,75);

        this.add(name_T);
        this.add(age_T);
        this.add(address_T);
        this.add(telephone_T);
        this.add(xueli_T);
        this.add(zhenshu_T);
        this.add(school_T);
        this.add(jieshao_T);
        this.add(enter);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isDelete = JOptionPane.showConfirmDialog(null, " 确认下单？", "提示", JOptionPane.YES_NO_OPTION);
                if (isDelete == JOptionPane.YES_OPTION) {
                     new UpdateSQL().UpdataState(id,myid,subject,new SelectSQL().SelectJob(myid));//修改teacher的状态,由YES转为学生的ID
                } else System.out.println("取消了选择");
            }
        });
    }

    public void getDetailData(int i){

        String driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/dzx";//数据库URL地址
        Connection con = null;//登录许可证
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT * FROM user_main a join user_teacher b on a.id = b.id where b.id = "+i+"";
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
                    name = rs.getString("name");
                    age = rs.getString("age");
                    address = rs.getString("address");
                    telephone = rs.getString("telephone");
                    jieshao = rs.getString("jieshao");
                    xueli = rs.getString("xueli");
                    zhenshu = rs.getString("zhenshu");
                    school = rs.getString("school");
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

    }
}
