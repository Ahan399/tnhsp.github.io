package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterJFrame extends JFrame {

    JLabel name_L = new JLabel("用户名");
    JLabel word_L = new JLabel("密码");
    JLabel address_L = new JLabel("住址");
    JLabel age_L = new JLabel("年龄");
    JLabel telephone_L = new JLabel("电话号码");
    JLabel job_L = new JLabel("职业");
    JTextField name_T = new JTextField();
    JTextField word_T = new JTextField();
    JTextField address_T = new JTextField();
    JTextField age_T = new JTextField();
    JTextField telephone_T = new JTextField();
    JComboBox job_C = new JComboBox();//文本选择框组件
    JButton submit = new JButton("确认");
    String job_T = "";


    public RegisterJFrame(){
        this.setLayout(null);
        setTitle("请填写注册信息");
        setSize(280,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        name_L.setHorizontalAlignment(SwingConstants.CENTER);//标签字体居中
        word_L.setHorizontalAlignment(SwingConstants.CENTER);
        address_L.setHorizontalAlignment(SwingConstants.CENTER);
        age_L.setHorizontalAlignment(SwingConstants.CENTER);
        telephone_L.setHorizontalAlignment(SwingConstants.CENTER);
        job_L.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("隶书",Font.PLAIN,20);

        name_L.setFont(font);//应用画笔
        name_L.setForeground(Color.BLUE);
        word_L.setFont(font);
        word_L.setForeground(Color.BLUE);//设置标签字体大小颜色
        address_L.setFont(font);
        address_L.setForeground(Color.BLUE);//设置标签字体大小颜色
        age_L.setFont(font);
        age_L.setForeground(Color.BLUE);//设置标签字体大小颜色
        telephone_L.setFont(font);
        telephone_L.setForeground(Color.BLUE);//设置标签字体大小颜色
        job_L.setFont(font);
        job_L.setForeground(Color.BLUE);//设置标签字体大小颜色

        job_C.addItem("教师");
        job_C.addItem("学生");


        name_L.setBounds(10,50,80,100);//设置组件位置与大小
        word_L.setBounds(25,100,50,100);
        address_L.setBounds(25,150,50,100);
        age_L.setBounds(25,200,50,100);
        telephone_L.setBounds(5,250,80,100);
        job_L.setBounds(25,300,50,100);

        name_T.setBounds(100,85,150,30);
        word_T.setBounds(100,135,150,30);
        address_T.setBounds(100,185,150,30);
        age_T.setBounds(100,235,150,30);
        telephone_T.setBounds(100,285,150,30);

        job_C.setBounds(100,335,150,30);

        submit.setBounds(190,520,65,35);

        this.add(name_L);
        this.add(word_L);
        this.add(address_L);
        this.add(age_L);
        this.add(telephone_L);
        this.add(job_L);

        this.add(name_T);
        this.add(word_T);
        this.add(address_T);
        this.add(age_T);
        this.add(telephone_T);

        this.add(job_C);

        this.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 * 测试用
                 */
                System.out.println("用户名内容:"+name_T.getText());//获取文本框值
                System.out.println("密码内容:"+word_T.getText());
                System.out.println("地址内容:"+address_T.getText());
                System.out.println("年龄内容:"+age_T.getText());
                System.out.println("电话内容:"+telephone_T.getText());

                if(job_C.getSelectedIndex() == 0)
                {
                    System.out.println("职业：教师");
                    job_T="teacher";
                }
                else if(job_C.getSelectedIndex() == 1)
                {
                    System.out.println("职业：学生");
                    job_T="student";
                }
                /**
                 * 检测输入是否合规，若合规写入数据库
                 */
                if("".equals(name_T.getText())||"".equals(word_T.getText())||"".equals(address_T.getText())||"".equals(age_T.getText())||"".equals(telephone_T.getText())){
                    JOptionPane.showMessageDialog(null,"请填写完整信息","错误",JOptionPane.WARNING_MESSAGE);
                    System.out.println("输入信息不合法");
                }else {

                   UpdateSQL update = new UpdateSQL();
                    update.InsertData(name_T.getText(),word_T.getText(),address_T.getText(),age_T.getText(),telephone_T.getText(),job_T);
                    System.out.println("输入信息合法");
                }

                name_T.setText("");//清空显示
                word_T.setText("");
                address_T.setText("");
                age_T.setText("");
                telephone_T.setText("");
            }
        });
    }
}
