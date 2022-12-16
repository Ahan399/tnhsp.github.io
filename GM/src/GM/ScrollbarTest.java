package GM;

import java.awt.*; //引入java接口
import java.awt.event.*;   //引入java接口
import javax.swing.JFrame;  //引入java接口
import javax.swing.JLabel;  //引入java接口
import javax.swing.JPanel;  //引入java接口

public  class ScrollbarTest implements AdjustmentListener {  // 创建一个类ScrollbarTest，实现接口 AdjustmentListener
    JLabel lab;  //定义变量
    JFrame f;    //定义变量
    JPanel pnlMain;    //定义变量
    Scrollbar Hsb ,Vsb; //定义变量
    int x = 0,y = 0;   //定义变量
    public ScrollbarTest() {   //构造一个函数完成以下功能
        f =new JFrame("滚动条示列");   //定义界面的标题
        lab =new JLabel("滚动条示列");  //定义标签的内容
        Font fontser = new Font("宋体",Font.BOLD,15);  //设置字体的大小
        lab.setFont(fontser);   //设置字体
        Hsb = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,300);  //定义滚动条
        Vsb = new Scrollbar(Scrollbar.VERTICAL,0,10,0,200); //定义滚动条
        Hsb.addAdjustmentListener(this);  //添加监听器
        Vsb.addAdjustmentListener(this);//添加监听器
        pnlMain = new JPanel();  //定义容器
        pnlMain.add(lab);  //在界面中添加容器
        f.add(pnlMain,BorderLayout.CENTER);//在界面中添加滚动条
        f.add(Hsb, BorderLayout.SOUTH);//在界面中添加滚动条
        f.add(Vsb,BorderLayout.EAST);//在界面中添加滚动条
        pnlMain.setLayout(null);  //利用NULL布局
        lab.setBounds(120,90,100,25);  //设置标签在界面中的位置
        f.setSize(350, 250);  //设置标签在界面中的大小
        f.setVisible(true);  //设置标签在界面中的可见性
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getValue());
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        new ScrollbarTest();
    }

}

