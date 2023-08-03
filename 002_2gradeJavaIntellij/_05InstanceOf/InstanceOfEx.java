package _05InstanceOf;

import javax.crypto.spec.PSource;

/*Instanceof 연산자
* -타입확인이 가능한 연산지(타입이 같으면 true/다르면 false)
* -보통 다운 캐스팅을 하기 전 타입변환이 가능한지 확인을 하고자 할 때 사용한다.
* -형식 : 객체 intstanceof 클래스 타입
* instanceof 연산자를 이용하여 상속 관계에 따라 레퍼런스가 가리키는 객체의 타입을 알아본다. */
class Person{} //클래스 Person
class Student extends Person{} //Student클래스는 Person 클래스 상속(서브 클래스)
class Researcher extends Person{} //Researcher는 Person클래스를 상속(서브 클래스)
class Professor extends Researcher{} //Professor는 Researcher클래스를 상속(서브 클래스

public class InstanceOfEx { //main
    static void print(Person p){ //객체 생성(인스턴스 생성)
        if(p instanceof Person) //instanceof 연산자 (p가 Person타입인지 확인
            System.out.println("Person");
        if(p instanceof Student)
            System.out.println("Student");
        if(p instanceof Researcher)
            System.out.println("Researcher");
        if(p instanceof Professor)
            System.out.println("Professor");
        System.out.println();
    }
    //main
    public static void main(String[] args) {
        System.out.print("new Student()->\t");
        print(new Student()); //객체 Student 생성(p가 Student 객체 생성)(Student클래스가 Person타입인지 확인)
        System.out.print("new Researcher()->\t");
        print(new Researcher()); //객체 Researcher생성(p가 Reaearcher객체 생성(Researcher클래스가 Person 타입인지 확인)-Person과 Student
        System.out.print("new Professor()->\t");
        print(new Professor()); //객체 Professor생성(p가 Professor객체 생성(Professor클래스가 Person 타입인지 확인)-Person, Researcher,Professor

    }
}
