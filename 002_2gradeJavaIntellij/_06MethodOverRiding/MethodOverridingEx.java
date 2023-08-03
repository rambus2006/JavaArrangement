package _06MethodOverRiding;
/*메소드 오버라이딩

         -슈퍼클래스의 메소드를 서브 클래스에서 재정의하는 것 =>객체지향의 다형성 실현
        - 기본적으로 한 클래스 내에 같은 이름의 메소드를 둘 이상 가질 수 없지만, 매개변수의 개수나 타입 혹은 순서를 다르게 하면 같은 이름의 메소드를 여러개 작성할 수 있다.
        - 단, 다음과 같이 메서드 반환 타입만 다르게 메서드 오버로딩은 불가능
        - 동적 바인딩이 발생한다.(서브 클래스에 오버라이딩된 메소드가 무조건 실행된다.) */

class Shape{ //슈퍼 클래스 Shape
    public Shape next; //멤버 변수 next
    public Shape(){next=null;} //Shape메소드(슈퍼 클래스의 메소드)
    public void draw(){
        System.out.println("Shape");
    } //draw메소드(슈퍼클래스의 메소드)
}
class Line extends Shape{ //Line 서브 클래스1
    public void draw(){
        System.out.println("Line");
    } //draw 메소드 재정의
}
class Rect extends Shape{ //Rect 서브 클래스2
    public void draw(){
        System.out.println("Rect");
    } //draw메소드 재정의
}
class Circle extends Shape{ //Circle 서브 클래스3
    public void draw(){
        System.out.println("Circle");
    }//draw 메소드 재정의
}
public class MethodOverridingEx { //main
    public static void paint(Shape p){
        p.draw(); //p가 가리키는 객체 내에 오버라이딩된 draw()호출 (동적 바인딩)
    } //static 메소드(앞의 public 은 붙인 것)S

    public static void main(String[] args) {
        Line line=new Line();//Line 객체 생성
        paint(line); //Shape의 멤버에서 Line의 멤버로 동적 바인딩(실행 이후에 런타임에 호출될 함수가 결정되는 것)  =>결괏값 line
        paint(new Shape()); //Shape객체 생성 => class Shape 실행 => Shape
        paint(new Line()); //Line 객체 생성=> class Line 실행=>Line
        paint(new Rect()); //Rect객체 생성=> class Rect 실행=> Rect
        paint(new Circle()); //Circle 객체 생성=>class Circle=> Circle
    }
}
