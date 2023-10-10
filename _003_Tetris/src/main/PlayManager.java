package main;

import main.GamePanel;
import mino.Block;
import mino.Mino;
import mino.Mino_L1;

import java.awt.*;

public class PlayManager {
    //Main Play Area
    final int WIDTH=360;
    final int HEIGHT=600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    //others
    public static int dropInterval =60;

    public PlayManager(){
        //Main Play Area Frame
        left_x=(GamePanel.WIDTH/2) - (WIDTH/2);
        right_x = left_x + WIDTH;
        top_y=50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;

        //Mino 세팅
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X,MINO_START_Y);
    }
    public void update(){
        currentMino.update();
    }
    public void draw(Graphics g2){
        //Draw Play Area Frame
        g2.setColor(Color.white);
//        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4,top_y-4,WIDTH+8,HEIGHT+8);

        //Draw Next Mino Frame
        int x = right_x + 100;
        int y = bottom_y -200;
        g2.drawRect(x,y,200,200);
        g2.setFont(new Font("Arial",Font.PLAIN,30));
//        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("NEXT",x+60,y+60);

        if(currentMino != null){
            currentMino.draw((Graphics2D) g2);
        }

    }
}
