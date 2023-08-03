package _03Upcasting;

/*업캐스팅
* -자식 클래스 객체를 부모 클래스 타입으로 타입 변환하는 것을 업캐스팅이라고 한다.
* -업캐스팅 이후에는 부모 타입에서 제공하는 필드와 메서드에서만 접근할 수 있다.
* -업캐스팅과 메소드 오버라이딩을 통해서 다형성을 구현할 수 있다.
* */

class Person{
    String name; //name변수
    String id; //id 변수

    public Person(String name){     //생성자 Person
        this.name=name; //this.name에 name을 넣기
    }
}
class Student extends Person{ //Sudent는 Person을 상속 받음
    String grade; //grade변수
    String department; //departent변수
    public Student(String name){ //Student 생성자
        super(name); //super(name): 상속하는 부모 클래스의 생성자 호출 (Person(name)호출
    }
}
public class UpcastingEx {  //main
    public static void main(String[] args) {
        //업캐스팅 과정
        Person p; //Person 타입 p
        Student s=new Student("이재문"); //Student 객체 생성
        p=s; //업캐스팅 :  Student 객체의 멤버 중 Person 의 멤버(name, id,Persont생성자)만 사용 가능하다.
        System.out.println(p.name); //p.name
        System.out.println(p.id);

    }
}
