package _00Programmers;

import java.util.Objects;

public class Student {
    //필드 선언
    String name;
    String number;
    int birthYear;

    @Override
    public boolean equals(Object o) { //Obj와 this를 비교
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; //obj가 null이면 false 반환
        Student student = (Student) o;
        return birthYear == student.birthYear && Objects.equals(name, student.name) && Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() { //해시코드 두개를 같은 값으로 출력
        return Objects.hash(name, number, birthYear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public static void main(String[] args) {
        Student a1 = new Student();
        a1.name="홍길동";
        a1.number="1234";
        a1.birthYear=1995;

        Student a2=new Student();
        a2.name="홍길동";
        a2.number="1234";
        a2.birthYear=1995;

        if(a1.equals(a2))
            System.out.println("a1==a2");
        else//다르게 나오는 이유는 Overriding을 하지 않았기 때문
            System.out.println("a!=a2");

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());

        //둘 다 오버라이딩하는 toString()메소드가 있으면 호출한다.
        System.out.println(a1);
        System.out.println(a1.toString());

    }
}
