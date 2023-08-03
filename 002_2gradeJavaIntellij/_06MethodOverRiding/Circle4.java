package _06MethodOverRiding;
/*
* 동적 바인딩
* - 실행할 메소드를 실행중에 결정'
* -오버라이딩 메소드가 항상 호출
* */
class shape5{
    protected String name;
    public void paint(){
        draw(); //draw메소드 호출
    }
    public void draw(){ //동적 바인딩이 일어남
        System.out.println("Shape");
    }
}
public class Circle4 extends shape5{
    @Override
    public void draw(){
        System.out.println("Circle");
    }

    public static void main(String[] args) {
        shape5 b = new Circle4();
        b.paint(); //메소드 오버라이딩, paint 메소드 호출
    }

}
