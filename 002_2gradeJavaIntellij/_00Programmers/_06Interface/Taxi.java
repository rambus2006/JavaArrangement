package _00Programmers._06Interface;

public class Taxi implements Meter {
    // Meter인터페이스의 start와 stop메소드를 구현해야 합니다.
    public void start(){

    }
    public int stop(int distance){
        return distance*2;
    }
}