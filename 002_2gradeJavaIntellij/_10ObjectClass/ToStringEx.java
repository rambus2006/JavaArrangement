package _10ObjectClass;

/*
[toString()메소드]
  - 형식 public String toString(){}
  - 객체를 문자열로 반환
  - Object클래스에 구현된 toString()이 반환하는 문자열
  - 객체+문자열이 객체.toString()+문자열 로 바뀌어진다.
 */

class PointToString{
    private int x,y;
    public PointToString(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class ToStringEx {
    public static void main(String[] args) {
        PointToString p = new PointToString(2,3);
        System.out.println(p.toString());
        System.out.println(p); //p는 p.toString 으로 자동 변환
        System.out.println(p+"입니다."); // p.toString() + "입니다."로 자동 변환
    }
}
