package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // 화면 설정
    public static final int WIDTH=1280;
    public static final int HEIGHT=720;
    private static final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public GamePanel(){
        //패널 설정
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        pm = new PlayManager();
    }
    //스레드 활성화 해서 여기에서 게임을 시작해 gameTread를 활성화
    //run 메서드를 실행해 시작
    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        //game loop 게임 루프 동영사 확인하기
        //업데이트 및 다시 그리기 메서드를 초당 60 회 호출
        double drawInterval = 1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            if(delta >=1){
                update();
                repaint();
                delta--;
            }
        }

    }
    private void update(){
        pm.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);

    }
}
