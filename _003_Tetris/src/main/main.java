package main;

import javax.swing.*;

//https://www.youtube.com/watch?v=N1ktYfszqnM
// 27m 34s
public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //GamePanel을 화면에 추가
        GamePanel gp=new GamePanel();
        window.add(gp);
        window.pack();

        //화면에 안나오는 속성
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();
    }
}
