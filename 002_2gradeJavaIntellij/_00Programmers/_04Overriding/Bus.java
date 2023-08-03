package _00Programmers._04Overriding;

public class Bus extends Car {
    // run 메소드를 오버라이드 하세요. 메소드의 접근 제한자는 public이어야 합니다.
    @Override
    public void run(){
        System.out.println("차가 달리면서 다음 정거장을 안내합니다.");
    }
}