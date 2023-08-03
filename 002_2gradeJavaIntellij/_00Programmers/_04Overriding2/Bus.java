package _00Programmers._04Overriding2;

public class Bus extends Car {
    public void run() {
        // Car 클래스의 run을 호출합니다.
        super.run();
        System.out.println("다음 정거장을 안내합니다.");
    }
}