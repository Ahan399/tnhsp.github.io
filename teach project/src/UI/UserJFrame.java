package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

public class UserJFrame extends JFrame{


    int myid;
    public UserJFrame(){


        setLayout(null);

        setTitle("家教管理系统");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    public void addUserJPanel(){
        System.out.println("id是:"+myid);

        JButton refresh = new JButton("刷新");
        UserJPanel pr2 = new UserJPanel();
        ReleaseJPanel pr3 = new ReleaseJPanel();

        refresh.setBounds(720,530,60,30);
        this.add(refresh);

        pr2.myid = myid;//传递用户ID
        pr2.addServer();//制作服务面板
        pr3.myid = myid;
        pr3.addReleaseData();//制作用户面板
        this.add(pr2);
        this.add(pr3);

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //刷新pr2与pr3
                UserJPanel pr22 = new UserJPanel();
                ReleaseJPanel pr33 = new ReleaseJPanel();
                pr22.myid = myid;
                pr33.myid = myid;

                pr2.Y_Location=0;//全局参数恢复初始值
                pr2.Datacount=0;
                pr2.myid=0;
                pr2.removeAll();//组件归零

                pr2.add(pr22);
                pr2.validate();
                pr2.repaint();
                pr2.addServer();

                pr3.removeAll();//组件归零

                pr3.add(pr33);
                pr3.validate();
                pr3.repaint();
                pr3.addReleaseData();

            }
        });
    }
    }
