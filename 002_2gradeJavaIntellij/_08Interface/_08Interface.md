> 인터페이스
> 
- 클래스가 구현해야 할 메소드들이 선언되는 추상형
- 필드(멤버변수) 선언 불가,객체 생성불가
- 인터페이스 타입의 변수 선언 가능
- 인터페이스 목적; 스펙을 주어 클래스들이 기능을 서로 다르게 구현할 수 있도록 하는 클래스의 규격 선언이며, 클래스의 다형성을 실현하는 도구이다.
- 인터페이스 구현: 인터페이스를 상속받는 클래스는 인터페이스의 모든 추상 메소드 반드시 구현
- 다른 인터페이스 상속 가능
- 인터페이스의 다중 상속 가능
- 형식(선언하는 방법)

> ->interface 키워드로 선언
> 
- 역사

> ● java7) 인터페이스는 상수와 추상메소드로만 구성

```
interface PhoneInterface {//인터페이스 선언public static final int TIMEOUT = 10000;//상수 필드 public static final 생략 가능public abstract void sendCall();//추상메소드 public abstract 생략 가능public abstract void receiveCall();//추상 메소드 public abstract 생략 가능public default void printLogo(){//default 메소드 public 생략 가능
    	System.out.println("**Phone**");
    };
}
```