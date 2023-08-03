package _19PerformTest._02AbstractClass;
/*
Q1
클래스를 구현할 때 메서드 몸체를 구현하지 않고 선언만 하는 메서드를 [  ]라고 하고, 이를 포함한 클래스를 [  ]라고 한다.


Q2
상수를 선언할 때 상속받은 클래스에서 메서드를 재정의하지 못하도록 사용하는 예약어는 [  ]이다.


Q3
추상 클래스나 추상 메서드를 선언할 때 사용하는 예약어는 [  ]이다.


Q4
로직 흐름을 정의한 메서드이며 메서드 내부에서 일반 메서드나 구현되지 않은 추상 메서드를 호출. 흐름이 변하지 않도록 하위 클래스에서 재정의하지 못하게 final로 선언하는 메서드를 [  ]라고 한다.
 */
/* Car 추상 클래스를 상속받는 Sonata,Avante,Gradeur,Genesis 클래스가 있다. 각 차는 주행하기 위해 다음 순서로 움직인다.
run(){
        start();
        drive();
        stop();
        turnoff();
 }
 */
public abstract class  Car {
    public abstract void start();
    public abstract void drive();
    public abstract void stop();
    public abstract void turnoff();

    public void run(){
        start();
        drive();
        stop();
        turnoff();
    }
}
class Sonata extends Car{
    @Override
    public void start(){
        System.out.println("Sonata 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("Sonata 달립니다.");
    }
    @Override
    public void stop(){
        System.out.println("Sonata 멈춥니다. ");
    }
    @Override
    public void turnoff(){
        System.out.println("Sonata 시동을 끕니다.");
    }
}
class Avante extends Car{
    @Override
    public void start(){
        System.out.println("Avante 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("Avante 달립니다.");
    }
    @Override
    public void stop(){
        System.out.println("Avante 멈춥니다. ");
    }
    @Override
    public void turnoff(){
        System.out.println("Avante 시동을 끕니다.");
    }
}
class Gradeur extends Car{
    @Override
    public void start(){
        System.out.println("Gradeur 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("Gradeur 달립니다.");
    }
    @Override
    public void stop(){
        System.out.println("Gradeur 멈춥니다. ");
    }
    @Override
    public void turnoff(){
        System.out.println("Gradeur 시동을 끕니다.");
    }
}
class Genesis extends Car{
    @Override
    public void start(){
        System.out.println("Genesis 시동을 켭니다.");
    }
    @Override
    public void drive(){
        System.out.println("Genesis 달립니다.");
    }
    @Override
    public void stop(){
        System.out.println("Genesis 멈춥니다. ");
    }
    @Override
    public void turnoff(){
        System.out.println("Genesis 시동을 끕니다.");
    }
}
class CarMain extends Car{
    public static void main(String[] args) {

    }

    @Override
    public void start() {
        
    }

    @Override
    public void drive() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void turnoff() {

    }
}