package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ReleaseJPanel extends JPanel {

    int myid = 0;
    BufferedImage bg2 = ImageUtil.getImg("/img/一对一.jpg");
    //BufferedImage bg3 = ImageUtil.getImg("/img/聊天框.jpg");
    BufferedImage bg4 = ImageUtil.getImg("/img/住宅楼.jpg");
    String subject = "";

    public ReleaseJPanel(){

        setLayout(null);
        setBounds(470,0,330,600);
        setBackground(Color.PINK);
        setVisible(true);
        System.out.println("/n 发布面板开启,ID为:"+myid);

    }
    public void paint(Graphics g){

        super.paint(g);
        g.setColor(Color.GRAY);
        g.drawImage(bg2,0,0,330,90,null);
        //g.drawImage(bg3,10,150,80,80,null);
        g.drawLine(0, 170,330,170); //两点画直线

        g.drawImage(bg4,225,180,80,80,null);

        g.drawLine(0, 270,330,270); //两点画直线
        super.paintComponents(g);//防止背景图覆盖组件显示

    }
    public void addReleaseData(){

        String Myjob = new SelectSQL().SelectJob(myid);//检测职业
        String Mystate = new SelectSQL().SelectState(myid);//检测状态
       // System.out.println("检测到用户为教师"+Myjob);
        if("teacher".equals(Myjob)){

            System.out.println("检测到用户为教师");
            JButton confirm = new JButton("发布");
            JComboBox choiceSubject = new JComboBox();

            choiceSubject.addItem("语文");
            choiceSubject.addItem("数学");
            choiceSubject.addItem("英语");
            choiceSubject.addItem("美术");
            choiceSubject.addItem("音乐");
            choiceSubject.addItem("体育");

            choiceSubject.setBounds(90,105,65,30);
            confirm.setBounds(170,105,65,30);

            this.add(choiceSubject);
            this.add(confirm);
            //建立交易信息标签
            if(!"YES".equals(Mystate)&&!"NO".equals(Mystate)){

                String customer = new SelectSQL().getCustomerData(myid,0,Myjob);//查询老师或学生的服务信息！双职业
                String address = new SelectSQL().getCustomerData(myid,1,Myjob);
                JLabel business = new JLabel("客户："+customer);
                JLabel business2 = new JLabel("地址："+address);

                business.setHorizontalAlignment(SwingConstants.CENTER);
                business.setHorizontalAlignment(SwingConstants.CENTER);
                Font font = new Font("微软雅黑",Font.PLAIN,15);
                business.setFont(font);
                business.setForeground(Color.black);
                business2.setFont(font);
                business2.setForeground(Color.black);

                business.setBounds(30,180,120,50);
                business2.setBounds(40,220,120,50);

                this.add(business);
                this.add(business2);
            }else if("NO".equals(Mystate)){
                System.out.println("现在，你的状态为NO，可以选择科目发布一项新的服务");
                JLabel StandBy = new JLabel("正在等待发布一项新服务...");
                StandBy.setBounds(30,200,170,45);
                this.add(StandBy);
            }else if("YES".equals(Mystate)){
                JLabel wait = new JLabel("正在等待学生接单...");
                wait.setBounds(30,200,170,45);
                this.add(wait);
            }

            confirm.addActionListener(new ActionListener() {
                @Override

                    public void actionPerformed (ActionEvent e){
                    int isORno = JOptionPane.showConfirmDialog(null, " 是否确认发布服务？", "提示", JOptionPane.YES_NO_OPTION);
                    if(isORno == JOptionPane.YES_OPTION) {
                        //点击确认时
                        if(!"YES".equals(Mystate)){
                            //状态不是YES，通过！
                            if (choiceSubject.getSelectedIndex() == 0) {
                                subject = "Chinese";
                                new UpdateSQL().UpdataState("YES",myid,subject,Myjob);//由非YES修改状态为YES，即为发布状态
                            } else if (choiceSubject.getSelectedIndex() == 1) {
                                subject = "maths";
                                new UpdateSQL().UpdataState("YES",myid,subject,Myjob);
                            } else if (choiceSubject.getSelectedIndex() == 2) {
                                subject = "English";
                                new UpdateSQL().UpdataState("YES",myid,subject,Myjob);
                            } else if (choiceSubject.getSelectedIndex() == 3) {
                                subject = "art";
                                new UpdateSQL().UpdataState("YES",myid,subject,Myjob);
                            }else if (choiceSubject.getSelectedIndex() == 4) {
                                subject = "music";
                                new UpdateSQL().UpdataState("YES", myid, subject,Myjob);
                            }else if (choiceSubject.getSelectedIndex() == 5) {
                                subject = "sports";
                                new UpdateSQL().UpdataState("YES", myid, subject,Myjob);
                            }
                        }else JOptionPane.showMessageDialog(null, " 不能重复发布服务 ", "警告 ", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });


        }else if("student".equals(Myjob)){
            System.out.println("检测到用户为学生");
            JButton finish = new JButton("委托完成");
            finish.setBounds(105,105,115,30);

            this.add(finish);

            //该用户ID在一个teacher用户的state里时显示信息面板
            if(new SelectSQL().whetherBuy(myid)){
                String teacherName = new SelectSQL().getCustomerData(myid,0,Myjob);//查询老师或学生的服务信息！双职业
                String telephoneNumber = new SelectSQL().getCustomerData(myid,2,Myjob);
                JLabel business = new JLabel("服务者："+teacherName);
                JLabel business2 = new JLabel("电话："+telephoneNumber);

                business.setHorizontalAlignment(SwingConstants.CENTER);
                business.setHorizontalAlignment(SwingConstants.CENTER);
                Font font = new Font("微软雅黑",Font.PLAIN,15);
                business.setFont(font);
                business.setForeground(Color.black);
                business2.setFont(font);
                business2.setForeground(Color.black);

                business.setBounds(12,180,110,40);
                business2.setBounds(18,220,150,40);

                this.add(business);
                this.add(business2);

            }else {
                System.out.println("请选择一项条家教服务讯息");
                JLabel StandBy = new JLabel("请在左侧请选择你的家教服务...");
                StandBy.setBounds(30,200,170,45);
                this.add(StandBy);
            }
            finish.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int isORno = JOptionPane.showConfirmDialog(null, " 您下单的服务是否已完成？", "提示", JOptionPane.YES_NO_OPTION);
                    if(isORno == JOptionPane.YES_OPTION) {
                        if(new SelectSQL().whetherBuy(myid)){
                            //检测到已经下单过服务才执行
                            int teacherID = Integer.parseInt(new SelectSQL().getCustomerData(myid,3,Myjob));

                            new UpdateSQL().UpdataState("NO",teacherID,subject,Myjob);//委托完成，把服务者(老师）状态改为NO
                            System.out.println("委托事件已结束");

                        }else JOptionPane.showMessageDialog(null, "   你未下单任何服务 ", "警告 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        }


    }
}
