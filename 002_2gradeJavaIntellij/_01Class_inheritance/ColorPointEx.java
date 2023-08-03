package _01Class_inheritance;
/*
(x,y)의 한 점을 표현하는 Point 클래스와 이를 상속받아 색을 가진 점을 표현하는 Color
* Point클래스를 만들과 활용해보자
* */
//부모 클래스(슈퍼클래스)
class Point {
    private int x,y; //한점을 구성하는 x,y좌표,private 접근 제어자 : 어떠한 외부 환경에서도 접근 불가하며 같은 클래스 내부에서만 접근 가능
    public void set(int x,int y){ //같은 클래스의 setter를 활용해 접근
        this.x=x; this.y=y;
    }
    //점의 좌표 출력
    public void showPoint(){ //점의 좌표 출력
        System.out.println("("+x+","+y+")"); //출력문(this.x,this.y출력)
    }
}
//Point를 상속 받은 ColorPoint 선언
class ColorPoint extends Point{
    private String color; //점의 색 //점의 색을 private : 어떠한 외부 자극에도 접근 불가하며 같은 클래스 내부에서만 접근 가능
    public void setColor(String color){ //같은 클래스의 setColor메소드를 통해 접근
        this.color=color; //this.color에 넣기
    }
    //컬러점의 좌표 출력
    public void showColorPoint(){ //ShowColorPoint 메서드르 통해 컬러점의 좌표를 출력
        System.out.print(color); //this.color출력
        showPoint();//showPoint 메소드 호출, 부모 클래스인 Point에 있으니 extends(상속)해서 가져온다.
    }
}
//main
public class ColorPointEx {
    public static void main(String[] args) {
        Point p=new Point(); //Point 객체 생성
        p.set(1,2);  //setter에 1,2 =>this.x=1,this.y=2
        p.showPoint(); //점의 좌표인 (1,2)출력

        //ColorPoint 객체 생성
        ColorPoint cp=new ColorPoint();
        cp.set(3,4); //setter에 3,4 =>부모클래스(Point를 상속받는 자식클래스(서브클래스)이기 떄문에 set메소드를 쓸 수 있다.
                    //따라서 this.x=3, this.y=4 가 들어간다.
        cp.setColor("red"); //setColor메소드에 red 출력 =>this.color=red
        cp.showColorPoint(); //색깔 출력 (red), showPoint(3,4)출력
    }
}
