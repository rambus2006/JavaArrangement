package _06MethodOverRiding;

//동적 바인딩
/*
* 실행할 메소드를 실행 시에 결정
* 오버라이딩 메소드가 항상 호출
* */
public class shape4{
    protected String name;
    public void paint(){
        draw(); //draw 메소드 호출
    }
    public void draw(){
        System.out.println("Shape");
    }

    public static void main(String[] args) {
        shape4 a=new shape4();
        a.paint(); //public void paint호출
    }

}