package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public static boolean upPressed, downPressed,leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //키 눌렀을 때 화살표로 조종하기
    @Override
    public void keyPressed(KeyEvent e) { //키 값 가져오기
        //키보드에서 누른 키 정보 가져오기
        int code = e.getKeyCode();
        //w - 위쪽
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        // A - 왼쪽
        if(code ==KeyEvent.VK_A){
            leftPressed = true;
        }
        //S - 아래
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        //D - 오른쪽
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
