package UI;

import javax.swing.*;
import java.awt.*;

public class AppJFrame extends JFrame{

    public AppJFrame (){

        setTitle("家教管理系统-----请登录");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args){
        AppJFrame jr1 = new AppJFrame();
        AppJPanel pr1 = new AppJPanel();
        jr1.add(pr1);
        jr1.setVisible(true);

    }
}
