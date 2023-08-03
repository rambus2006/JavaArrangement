package _06MethodOverRiding;
/*오버라이딩
* -슈퍼 클래스의 메소드를 서브 클래스에서 재정의 하는 것=>객체지향의 다형성
* -기본적으로 한 클래스 내에 같은 이름의 메소드를 둘 이상 가질 수 없지만, 매개변수의 개수나 타입, 순서를 다
* 다르게 하면 같은 이름의 메소드를 여러개 작성할 수 있다.
* -동적 바인딩이 발생한다. (서브 클래스에 오버라이딩 된 메소드가 무조건 실행된다.)
* -단 다음과 같이 메소드 반환 타입만 다르게 메소드 오버로딩은 불가능하다.  */

class Shape2{ //슈퍼 클래스 Shape
    public Shape2 next; //멤버 변수 next
    public Shape2(){next=null;} //Shape메소드(슈퍼 클래스의 메소드)
    public void draw(){
        System.out.println("Shape");
    } //draw메소드(슈퍼클래스의 메소드)
}
class Line2 extends Shape{ //Line 서브 클래스1
    public void draw(){
        System.out.println("Line");
    } //draw 메소드 재정의(메소드 오버라이딩)
}
class Rect2 extends Shape{ //Rect 서브 클래스2
    public void draw(){
        System.out.println("Rect");
    } //draw메소드 재정의(메소드 오버라이딩)
}
class Circle2 extends Shape{ //Circle 서브 클래스3
    public void draw(){
        System.out.println("Circle");
    }//draw 메소드 재정의(메소드오버라이딩)
}
public class UsingOverride {
    public static void main(String[] args) {
        Shape start, last,obj;
        //링크리스트로 도형 생성하여 연결
        start = new Line2();//Line 객체 연결 (Line)
        last = start; //Shape타입 start
        obj=new Rect2(); //Shape타입 obj에 Rect 객체 생성(Rect)
        last.next=obj; //Line객체에 Rect객체 연결
        last=obj;
        obj=new Line2(); //Line객체 생성
        last.next=obj; //Line객체를 Rect에 연결
        last=obj;
        obj=new Circle2(); //Circle객체 생성
        last.next=obj; //Line객체에 Circle연결
        Shape p=start; //변수 p는 start를 가리킨다.
        while(p!=null){ //p가 null이 아닌 경우 (하지만 p는 null이다. 앞에서 shape으로 객체를 생성했기 때문)
            p.draw(); //p.draw ->따라서 해당되지 않는다.
            p=p.next;
        }
    }
}
