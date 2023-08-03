package _06MethodOverRiding;
/*정적 바인딩 */
/*
super는 슈퍼 클래스의 멤버를 접근할 때 사용되는 레퍼런스
서브 클래스에서만 사용
슈퍼 클래스의 메소드 호출
컴파일러는 super의 접근을 정적 바인딩으로 처리
* */
class Shape3{ //슈퍼 클래스
    //Circle이 여기로 들어가고
    protected String name; //같은 패키지에 존재하는 클래스 혹은 해당 클래스를 상속 받는 자식 클래스에서만 접근
    public void paint(){ //메소드 paint
        draw(); //draw메소드 호출
    }
    public void draw(){ //draw메소드
        System.out.println(name); //name출력 (앞에서 같은 패키지에 존재하는 클래스 혹은 해당 클래스를 상속 받는 자식 클래스에서만 접근 할 수 있는 변수)
    } //Circle 출력 하고
}
//서브 클래스 (상속) - 오버로드
public class Circle3 extends Shape3{
    protected String name; //같은 패키지에 존재하는 클래스 혹은 해당 클래스를 상속 받는 자식 클래스에서만 접근 가능
    @Override //상속
    public void draw(){

        super.name="Shape"; //super.name을 Shape로 줌
        name="Circle"; //name을 Circle로 줌
        super.draw(); //정적 바인딩
        System.out.println(name);
    }

    public static void main(String[] args) {
        Shape3 b=new Circle3();
        b.paint();
    }

}
