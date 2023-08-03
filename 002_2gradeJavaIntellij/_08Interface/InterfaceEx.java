package _08Interface;

interface PhoneInterface{ //인터페이스 선언
    final int TIMEOUT=10000; //상수 필드 선언
    void sendCall(); //추상메소드 (public abstract생략 가능)
    void receiveCall(); //추상 메소드(public abstract생략 가능)
    default void printLogo(){ //default 메소드 (인터페이스에 코드가 작성된 메소드/인터페이스에 구현하는 클래스에 자동 상속/public 접근 지정만 허용, 생략 가능)
        System.out.println("**Phone**"); //출력
    }
}

class SamsungPhone implements PhoneInterface{ //인터페이스 구현: 인터페이스의 추상메소드를 모두 구현한 클래스 작성(implements 키워드 사용, 여러개의 인터페이스 상속 가능)
    @Override
    public void sendCall(){ //interface에서 선언한 추상 메소드 public abstract void sendCall() 구현
        System.out.println("띠띠리링");
    }

    @Override
    public void receiveCall(){ //interface에서 선언한 추상 메소드 public abstract void receiveCall()구현
        System.out.println("전화가 왔습니다. 유치해");
    }
    public void flash(){ //메소드 추가 작성
        System.out.println("전화기에 불이 켜졌습니다.");
    }
}
public class InterfaceEx { //메인에서 실행
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone(); //Samsungphone 객체 생성,
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}
/*
* 인터페이스
* 1. 클래스가 구현해야 할 메소드를이 선언되는 추상형
* 2. 필드(멤버변수) 선언 불가, 객체 생성 불가
* 3. 인터페이스 타입의 변수 선언 가능
* 4. 목적: 스펙을 주어 클래스들이 기능을 서로 다르게 구현할 수 있도록 하는 클래스의 규격 선언이며, 클래스의 다형성을 실현하는 도구이다.
* 5. 구현: 인터페이스를 상속받는 크랠스는 인터페이스의 모든 추상 메소드 반드시 구현
* 6. 다른 인터페이스 상속 가능
* 7. 형식
* -interface키워드로 선언
* 8. 역사
* java7) 인터페이스는 상수와 추상 메소드로만 구성
* java8) 상수와 추상 메소드를 포함함
*        default 메소드 포함
* 9. 구성요소:
*  (1) 상수: public 만 허용, public static final 생략
*  (2) 추상메소드: public abstract 생략 가능
*  (3) default 메소드 : -인터페이스에 코드가 작성된 메소드
*                     - 인터페이스를 구현하는 클래스에 자동 상속
*                     - public 접근 지정만 허용,생략 가능
*  (4) private 메소드 : - 인터페이스 내에 메소드 코드가 작성되어야 함
*                      - 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능
*  (5) static메소드: public, private모두 지정 가능, 생략하려면 public
*
* <인터페이스 구현 >
 1. 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
 * - implements 키워드 사용
 * - 여러개의 인터페이스 동시 구현 가능
 * */