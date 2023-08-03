package _14StringBuffer;

import java.util.Objects;

/* 우클릭 ->Generate->왜 두개가 묶여있는가
* equals() and hashCode()
* */
class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String hobby;
    public Student(String id, String name, int age, String gender, String hobby)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(gender, student.gender) && Objects.equals(hobby, student.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, hobby); //해시코드와 equals는 같이 오버라이딩 해야 한다. 안의 요소가 똑같아야 한다.(ex.gender,hobby등)
    }
}
class ObjectStudy{
    public static void main(String[] args) {
        Student s1 = new Student("A1234", "김미림", 19, "여성", "게임"); //객체 생성
        Student s2 = new Student("A1234", "김미림", 19, "여성", "낚시");
        // 결과는 false이지만, 이것이 올바른 판단인가?
        System.out.println(s1.equals(s2)); //한번쯤은 논리적으로 생각해보자 , hobby가 다르다고 다른 사람인가? hobby가 필요한가?
        /*
        * [해시코드 ]
        * hachCode 의 정수값은 두 객체의 내용이 다르면 "가급적" 다른 숫자가 나오도록 설계가 되어 있음
        * */
    }
}
