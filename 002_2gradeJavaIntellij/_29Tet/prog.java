package _29Tet;

import java.util.*;

public class prog {
    public static void main(String[] args) {
        //0부터 99까지의 정수 리턴
        System.out.println((int)(Math.random() * 100));
        //랜덤 객체 선언
        Random ran = new Random();
        //랜덤 객체 중 0부터 99까지의 랜덤한 정수 리턴
        System.out.println(ran.nextInt(100));
    }
}