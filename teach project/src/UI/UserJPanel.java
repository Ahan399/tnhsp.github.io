package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserJPanel extends JPanel {

    BufferedImage bg1 = ImageUtil.getImg("/img/首页图像.jpg");
    BufferedImage bg2 = ImageUtil.getImg("/img/默认头像.jpg");
    JButton YuWen = new JButton("语文");
    JButton ShuXue = new JButton("数学");
    JButton YingYu = new JButton("英语");
    JButton MeiShu = new JButton("美术");
    JButton YinYue = new JButton("音乐");
    JButton TiYu = new JButton("体育");
    int Datacount = 0;
    int Y_Location = 0;
    String subject = "";
    String name = "";
    String age = "";
    String address = "";
    String telephone = "";
    String id = "";


    int myid = 0;

    public UserJPanel(){
        setLayout(null);
        setBounds(0,0,470,600);

        //JTextArea jta= new JTextArea();
        JScrollPane jsp = new JScrollPane();
        //jta.setBounds(10,80,350,540);
        //jsp.setBounds(360, 90, 20, 540);
        //jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        YuWen.setBounds(40,20,65,25);
        ShuXue.setBounds(140,20,65,25);
        YingYu.setBounds(240,20,65,25);
        MeiShu.setBounds(40,60,65,25);
        YinYue.setBounds(140,60,65,25);
        TiYu.setBounds(240,60,65,25);

        this.add(jsp);

        this.add(YuWen);
        this.add(ShuXue);
        this.add(YingYu);
        this.add(MeiShu);
        this.add(YinYue);
        this.add(TiYu);



        setBackground(Color.GRAY);
        setVisible(true);
    }
    public void paint(Graphics g){

        super.paint(g);
        g.setColor(Color.GRAY);
        g.drawImage(bg1,10,10,350,80,null);
        g.drawImage(bg2,375,10,80,80,null);
        super.paintComponents(g);//防止背景图覆盖组件显示

    }
    public void addTeachData(int y,String subject,String name,String address,String telephone,String id){

        JButton data = new JButton("学科："+subject+"    发布者："+name+"    地址："+address+"    联系方式："+telephone);
        data.setBounds(10,100+y,450,50);
        this.add(data);
        data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("检测到我的账号ID是："+myid);
                if(myid == Integer.parseInt(id)){
                    JOptionPane.showMessageDialog(null, "  你不能下单自己的服务 ", "警告 ", JOptionPane.ERROR_MESSAGE);
                }else if("teacher".equals(new SelectSQL().SelectJob(myid))){
                    JOptionPane.showMessageDialog(null, "  教师不能下单服务 ", "警告 ", JOptionPane.ERROR_MESSAGE);
                }else if(new SelectSQL().whetherBuy(myid)){
                    JOptionPane.showMessageDialog(null, "  您已下单的服务还未结束！ ", "警告 ", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    detailedJFrame detail = new detailedJFrame();
                    detail.addDetailData(id,myid,subject);//生成详细信息
                    //int isDelete = JOptionPane.showConfirmDialog(null, " 确认下单？", "提示", JOptionPane.YES_NO_OPTION);
                    //if (isDelete == JOptionPane.YES_OPTION) {
                    //    new UpdateSQL().UpdataState(id,myid,subject,new SelectSQL().SelectJob(myid));//修改teacher的状态,由YES转为学生的ID
                   // } else System.out.println("取消了选择");
                }
            }
        });
    }
    public void getData(int i){
        String driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/dzx";//数据库URL地址
        Connection con = null;//登录许可证
        ResultSet rs = null;
        Statement st = null;

        String sql = "SELECT a.name,b.subject,a.address,a.telephone,b.id FROM user_main a join user_teach_state b on a.id = b.id where b.state = 'YES'";
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
                    rs.next();//初始指针设置位置
                    for(int j=0;j<i;j++) {
                        rs.next();

                    }
                //System.out.print(rs.getString("name") + " x ");
                name = rs.getString("name");
                subject = rs.getString("subject");
                address = rs.getString("address");
                telephone = rs.getString("telephone");
                id = rs.getString("id");
                System.out.print("name:"+name+"  ");

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
    public void addServer(){
        Datacount = new SelectSQL().getDatacount();//服务数量计数
        System.out.println("本人ID为："+myid);
        for(int i=0;i<Datacount;i++){

            getData(i);
            //System.out.print("name:"+name+"  ");
            addTeachData(Y_Location,subject,name,address,telephone,id);
            Y_Location=Y_Location+60;

        }//制作服务面板
    }



}
