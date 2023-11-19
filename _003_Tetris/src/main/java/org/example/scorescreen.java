package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class scorescreen {
    JFrame f1 = new JFrame("score");
    JLabel jl1 = new JLabel("이름");
    JTextField jt1 = new JTextField();

    JLabel jl2 = new JLabel("점수");
    JTextField jt2 = new JTextField();

    JButton btn1 = new JButton("확인");


    public scorescreen(){
        f1.setBounds(0,0,600,200);
        f1.setLayout(new BorderLayout());
        f1.add(jl1,BorderLayout.CENTER);
        f1.add(jt1,BorderLayout.CENTER);
        f1.add(btn1);
    }

    public static void main(String[] args) {
        new scorescreen();
    }
}
