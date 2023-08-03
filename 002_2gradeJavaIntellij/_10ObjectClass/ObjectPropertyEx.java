package _10ObjectClass;
/*
[Object클래스]
        * <특징>
 * (1)java.lang 패키지에 포함되어 있음
         * (2)모든 클래스의 부모(슈퍼)클래스(모든 클래스에 강제 상속/모든 객체가 공동으로 가지는 객체의 속성을 나타내는 메소드 보유함)
         * <주요 메소드>
 * ● boolean equals(Object obj) : obj 가 가리키는 객체와 현재 객체를 비교하여 같으면 true리턴
         * ● ClassgetClass() : 현 객체의 런타임 클래스를 리턴 ->현재 실행되고 있는 클래스를 리턴한다.
         * ● int hashCode() : 현 객체에 대한 해시코드 값 리턴->어떤 값을 가지고 있는지 판별할 수 있는 코드
         * ● String toString() : 현 객체에 대한 문자열 표현을 리턴
         */
class Point{
    private int x, y; //private타입 변수: 어떠한 외부 환경에서도 접근이 불가하며, 같은 클래스 내부에서만 접근 가능
    private String id;
    public Point(int x,int y){ //Point클래스의 생성자,매개변수는 int x,int y
        this.x=x;
        this.y=y;
    }
}
public class ObjectPropertyEx {
    public static void print(Object obj){ //메소드 print(이름땜에 다른 명령어 있는 줄;;)에 모든 타입의 객체가 매개변수 자리에 들어갈 수 있다. (Object가 최상위 클래스이기 때문에 어떤 값도 다 대입 가능
        System.out.println(obj.getClass().getName()); //클래스 이름 출력(_09Package.Point)
        System.out.println(obj.hashCode()); //해시코드값 출력(1808253012)
        System.out.println(obj.toString()); //현 객체에 대한 문자열 표현을 리턴해서 출력(_09Package.Point@6bc7c054)
        System.out.println(obj);  //현 객체 obj 출력 (_09Package.Point@6bc7c054)
    }

    public static void main(String[] args) {
        Point p = new Point(2,3); //Point클래스 타입의 변수 p에 Point 객체를 생성(값에는 2,3)
        print(p); //Point(p): Point메소드에 변수 p를 넣고 실행
    }
}