package _10ObjectClass;

/*
Point 클래스에 equals() 작성하기
-Point 클래스에 두 점의 좌표가 같으면 true를 리턴하는 equals()를 작성하라.

[Object 클래스]
- java.lang패키지에 포함되어 있음
- 모든 클래스의 부모(슈퍼)클래스(모든 클래스에 강제 상속/모든 객체가 공동으로 가지는 객체의 속성을 나타내는 메소드 보유함)
- boolean equals(Object obj) : obj가 가리키는 객체와 현재 객체를 비교하여 같으면 true 리턴
 */
class PointEqual{
    private int x,y;
    public PointEqual(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean equals(Object obj){
        PointEqual p=(PointEqual)obj;
        if(x==p.x && y==p.y)
            return true;
        else return false;
    }
}
public class EqualsEx {
    public static void main(String[] args) {
        PointEqual a = new PointEqual(2,3);
        PointEqual b = new PointEqual(2,3);
        PointEqual c = new PointEqual(3,4);

        if(a==b)
            System.out.println("a==b");
        if(a.equals(b))
            System.out.println("a is equal to b");
        if(a.equals(c))
            System.out.println("a is equal to c");
    }
}
