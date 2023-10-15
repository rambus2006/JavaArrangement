package mino;

import java.awt.*;

//4가지 방향을 조정
public class Mino_L1 extends Mino{
    public Mino_L1(){
        create(Color.orange);
    }
    public void setXY(int x,int y){
        /* 0 b[1]
           0 b
           0 0 b[2]b[3]
        * */
        b[0].x=x;
        b[0].y=y;
        b[1].x=b[0].x;
        b[1].y=b[0].y - Block.SIZE;
        b[2].x=b[0].x;
        b[2].y=b[0].y + Block.SIZE;
        b[3].x=b[0].x + Block.SIZE;
        b[3].y=b[0].y + Block.SIZE;

    }

    //방향 조정
    public void getDirection1(){
        /* 0
           0
           0 0
        * */
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }
    public void getDirection2(){
        //0 0 0
        //0
        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x + Block.SIZE;
        b[1].y = tempB[1].y;
        b[2].x = tempB[2].x - Block.SIZE;
        b[2].y = tempB[2].y;
        b[3].x = tempB[3].x - Block.SIZE;
        b[3].y = tempB[3].y + Block.SIZE;
        updateXY(2);
    }
    public void getDirection3(){
        //0 0
        //  0
        //  0
        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x;
        b[1].y = tempB[1].y + Block.SIZE;
        b[2].x = tempB[2].x;
        b[2].y = tempB[2].y - Block.SIZE;
        b[3].x = tempB[3].x - Block.SIZE;
        b[3].y = tempB[3].y - Block.SIZE;
        updateXY(3);
    }
    public void getDirection4(){
        //    0
        //0 0 0
        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x - Block.SIZE;
        b[1].y = tempB[1].y;
        b[2].x = tempB[2].x + Block.SIZE;
        b[2].y = tempB[2].y;
        b[3].x = tempB[3].x + Block.SIZE;
        b[3].y = tempB[3].y - Block.SIZE;
        updateXY(4);
    }
    public void update(){}
}
