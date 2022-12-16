package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AppJPanel extends JPanel {

    JLabel sign = new JLabel("用户名");
    JLabel pass = new JLabel("密码");
    JTextField name = new JTextField();
    JTextField word = new JTextField();
    JButton in = new JButton("登录");
    JButton del = new JButton("取消");
    JButton register = new JButton("注册");
    BufferedImage bg = ImageUtil.getImg("/img/背景图片.jpg");
    int myid;

    public AppJPanel(){

        this.setLayout(null);//取消默认布局

        sign.setHorizontalAlignment(SwingConstants.CENTER);
        pass.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("仿宋",Font.PLAIN,30);
        sign.setFont(font);
        sign.setForeground(Color.black);
        pass.setFont(font);
        pass.setForeground(Color.black);//设置标签字体大小颜色


        sign.setBounds(190,120,100,200);//设置组件位置与大小
        pass.setBounds(195,210,100,200);

        name.setBounds(290,200,200,40);
        word.setBounds(290,290,200,40);


        in.setBounds(350,345,65,35);
        del.setBounds(425,345,65,35);
        register.setBounds(715,525,65,35);

        setBackground(Color.GREEN);
        this.add(sign);
        this.add(pass);
        this.add(name);
        this.add(word);
        this.add(in);
        this.add(del);
        this.add(register);

        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("用户名内容:"+name.getText());//获取文本框值
                System.out.println("密码内容:"+word.getText());

                if ("".equals(name.getText())) {
                    JOptionPane.showMessageDialog(null,"用户名不能为空","错误",JOptionPane.WARNING_MESSAGE);
                }else if (!("".equals(name.getText()))&&"".equals(word.getText())) {
                    JOptionPane.showMessageDialog(null,"密码不能为空","错误",JOptionPane.WARNING_MESSAGE);
                }else{
                    SelectSQL My = new SelectSQL();
                   if (My.MatchAccount(name.getText(),word.getText())){
                       myid = My.myid;
                       System.out.println("登录成功！账号ID为："+myid);
                       UserJFrame jr2 = new UserJFrame();//建立新窗体
                        jr2.myid = myid;
                        jr2.addUserJPanel();//建立新船体的面板，有两个
                        //new ScrollbarTest();
                   }else JOptionPane.showMessageDialog(null,"用户名或密码错误！","错误",JOptionPane.WARNING_MESSAGE);

                }
                name.setText("");//清空文本框
                word.setText("");
                name.requestFocus();
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText("");//清空文本框
                word.setText("");
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterJFrame();
            }
        });

    }


    /**
     *
     * 画图方法
     */
    public void paint(Graphics g){

        super.paint(g);
        g.setColor(Color.GRAY);

        g.drawImage(bg,0,0,800,600,null);
        g.drawString("1840918227邓志贤",10,550);
        super.paintComponents(g);//防止背景图覆盖组件显示

    }


}
