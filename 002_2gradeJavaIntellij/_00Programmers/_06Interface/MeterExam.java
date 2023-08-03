package _00Programmers._06Interface;

// 아래는 실행을 위한 코드입니다. 수정하지 마세요.
public class MeterExam {
    public static void main(String[]args){
        Taxi taxi = new Taxi();
        boolean a = Meter.class.isInstance(taxi);

        if(a!=true){
            System.out.println("Taxi클래스는 Meter인터페이스를 구현해야 합니다.");
        }
        else if(taxi.stop(200)!=400){
            System.out.println("stop(200)의 값은 400이어야 합니다.");
        }
        else{
            System.out.println("정답입니다. [제출]을 누르세요.");
        }
    }
}