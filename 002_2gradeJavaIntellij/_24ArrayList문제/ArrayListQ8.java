package _24ArrayList문제;

class Person {
    public String name;
    public String email; //값 넣기

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
public class ArrayListQ8 {
    public static void main(String[] args) {
        java.util.HashMap<String,Person> map = new java.util.HashMap<>();
        map.put("010-1234-5678",new Person("kim","kim@naver.com"));
        map.put("010-1234-1234",new Person("park","park@naver.com"));
        System.out.println(map.get("010-1234-5678")); //kim
    }
}
