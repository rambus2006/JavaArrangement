package _01Class_inheritance;
/*클래스 Person을 아래와 같은 멤버 필드를 갖도록 선언 하고 클래스 Student 는 클래스 Person을
상속 받아 각 멤버 필드에 값을 저장하시오. 이 예제에서 Person클래스의 private 필드인 weight는
Student 클래스에서는 접근이 불가능 하여 슈퍼클래스인 Person의 getter, setter메소드를 통해서만
조작이 가능하다.
private int weight
int age
protected int height
public String name*/

class Person{ //부모 클래스(슈퍼클래스)
    private int weight; //private변수 ,몸무게
    int age; //나이
    protected int height; //키
    public String name; //이름
    public void setWeight(int weight){ //weight의 setter
        this.weight=weight;
    }
    public int getWeight(){ //weight 의 getter
        return weight;
    }
}
//자식 클래스(서브클래스)
class Student extends Person{ //변수 weight, age, name,height르 상속 받는다.
    public void set(){ //set 메소드
        age=30;
        name="홍길동";
        height=175;
        setWeight(99); //weight를 private으로 줬기 때문에 setter
    }
}
public class InheritanceEx {
    public static void main(String[] args) { //main
        Student s= new Student(); //Student객체 생성
        s.set(); //set메소드호출
        System.out.println(s.age + s.name + s.height + s.getWeight()); //출력문
    }
}
/*결괏값
* 30
* 홍길동
* 175
* 99*/
