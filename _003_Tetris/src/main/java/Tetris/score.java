package Tetris;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class score {
    JFrame f3 = new JFrame();
    JPanel p3 = new JPanel();
    JLabel jl_name = new JLabel();
    JLabel jl_score = new JLabel();

    JTextField jf_name = new JTextField(20);
    JTextField jf_score = new JTextField(20);

    public score(){

        f3.setTitle("score");
        //Location check!
//        f3.setLocation((int)(screenSize.width-frameSize.width)/2,(int)(screenSize.height-frameSize.height)/2);
        f3.setSize(1200,1200);
        f3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f3.setVisible(true);
        f3.setLayout(null);


        p3.setBounds(0,0,1200,1200);
        p3.setLayout(new FlowLayout());


        jl_name.setOpaque(true);
        jl_name.setFont(new Font("serif", Font.BOLD,20));
        jl_name.setHorizontalAlignment(JLabel.CENTER);

        p3.add(jl_name);

        p3.add(jf_name);
        p3.add(jl_score);
        p3.add(jf_score);
        f3.add(p3);
    }

    public static void main(String[] args) {
        score sc = new score();

    }


}
