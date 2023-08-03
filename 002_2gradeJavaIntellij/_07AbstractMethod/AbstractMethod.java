package _07AbstractMethod;

/* 추상 메소드와 추상 클래스
<추상 클래스>
1. 추상 메소으를 하나라도 가진 크랠스
2. 추상 메소드가 없지만 abstract로 선언된 클래스
3. 객체를 생성할 수 없다.
4. 상속
 1) 단순 상속 : 추상 클래스를 상속받아, 추상메소드를 구현하지 않으면 추상 클래스가 된다. 서브클래스도 abstract로 선언해야 한다.
 2) 추상 클래스 구현 상속 : 서브 클래스에서 슈퍼 클래스의 추상 메소드를 구현(오버라이딩), 이떄 서브 클래스는 추상 클래스가 아니다.

 ex)
 //추상 클래스 Shape : 추상 메소드를 갖고 있는 추상 클래스
 abstract class Shape{
    public Shape(){}
    public void paint(){ draw();}
    abstract public void draw(); //추상 메소드
 }
 abstract class Line extends Shape{ //추상 클래스 draw를 상속 받기 때문
    public String toString(){ return "Line"; }
 }
5)용도 : - 슈퍼 클래스에서는 개념정의( 서브 클래스마다 다른 구현이 필요한 메소드는 추상 메소드로 선언한다. )
        - 각 서브 클래스에서 구체적 행위 구현(서브 클래스마다 목적에 맞게 추상 메소드를 다르게 구현 한다. )
        - 계층적 상속관계를 갖는 클래스 구조를 만들 떄 쓰인다.

<추상 메소드>
 - 선언 되어 있으나 구현되어 있지 않은 메소드, abstract로 선언
 public abstract String getName();
 public abstract void setName(String s);
 - 추상 메소드는 서브 클래스에서 오버라이딩 하여 구현해야 한다.
* */
