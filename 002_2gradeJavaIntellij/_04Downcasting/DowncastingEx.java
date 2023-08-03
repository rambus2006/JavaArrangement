package _04Downcasting;
/*다운캐스팅
* -슈퍼클래스 객체를 서브 클래스 타입으로 변환
* -개발자의 명시적 타입변환 필요-부모 클래스 타입의 객체를 자식 클래스 타입으로 타입 변환하는 것을 다운캐스팅이라고 함
-업캐스팅과는 달리 자식 클래스 타입의 개수는 이론적으로 무한하므로 명시적 타입 변환이 필요함
* */
class Person{ //class Person
    String name; //멤버변수 name
    String id; //멤버변수 id
    public Person(String name){ //Person(name)생성자 - 이재문
        this.name=name; //this.name에 name넣기
    }
}
class Student extends Person{ //Person상속 받는 서브 클래스
    String grade; //멤버변수 grade
    String department; //멤버변수 department
    public Student(String name){ //Student 생성자
        super(name); //super(name)-Person 생성자 호출 -이재문
    }
}
public class DowncastingEx { //main
    public static void main(String[] args) {
        Person p=new Student("이재문"); //업캐스팅(압축해서)
        Student s; //Student 타입 변수 s
        //(Student)타입 변환 필요
        s=(Student)p; //다운캐스팅 : 슈퍼 클래스 객체를 서브 클래스 타입으로 변환(Person 객체를 Student 타입으로 변환)
        System.out.println(s.name);
        s.grade="A"; //
        System.out.println(s.grade);
    }
}
