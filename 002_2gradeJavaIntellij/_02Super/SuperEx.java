package _02Super;
/*super를 이용하여 ColorPoint 클래스의 생성자에서 슈퍼 클래스 Point 의 생성자를 호출 하는 예를 보인다. */

class Point{
    private int x,y; //한점을 구성하는 x,y좌표

    public Point(int x, int y){
        this.x=this.y=0;
    } //point 생성자
    public void showPoint(){
        System.out.println("("+x+","+y+")");
    } //점의 좌표를 출력하는 메소드
}
//서브 클래스
class ColorPoint extends Point{ //point 를 상속받음
    private String color; //변수 색깔
    public ColorPoint(int x,int y,String color){ //ColorPoint는 int x,int y,String color를 입력받음
        super(x,y); //Point 의 생성자를 호출
        this.color=color; //String color을 this.color에 넣기
    }
    public void showColorPoint(){ //showColorPoint 메소드 : ColorPoint를 보여준다.
        System.out.println(color); //색깔을 출력(this.color)
        showPoint(); //Point의 showPoint메소드를 호출(상속을 받기 때문에 사용 가능)
    }
}
public class SuperEx { //main
    public static void main(String[] args) {
        ColorPoint cp=new ColorPoint(5,6,"blue"); //ColorPoint 객체 생성
        cp.showColorPoint(); //showColorPoint 메소드 호출 (색깔 출력, showPoint()) (x,y)
    }
}
