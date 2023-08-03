package _15HashCode;
/*
class ObjectStudy{
    public static void main(String[] args) {
        Student s1 = new Student("A1234", "김미림", 19, "여성", "게임");
        Student s2 = new Student("A1234", "김미림", 19, "여성", "게임");
        Student s3 = new Student("A2345", "박미림", 30, "남성", "낚시");
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // false
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode()); // s1과 같음 (equals 메서드가 참이면 해시코드는 반드시 같다는 요건 충족);
        System.out.println(s3.hashCode()); // s1과 다름 (하지만 "같을수도" 있음)
        //s1과 s3를 비교,
        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set.size()); // 2 (하지만 hashCode 메서드 구현을 주석처리하면?)
        Map<Student, String> map = new HashMap<Student, String>();
        map.put(s1, "Hello");  //equals를 자동으로 호출해서 같다고 생각함
        map.put(s2, "World"); // "Hello"를 덮어써서 World가 됨
        map.put(s3, "Java");
        System.out.println(map.size()); // 2 (하지만 hashCode 메서드 구현을 주석처리하면?)
        System.out.println(map.get(s2)); // "World"
        System.out.println(map.get(s1)); // 똑같이 "World" (하지만 hashCode 메서드 구현을 주석처리하면?)
    }
        /*
         * [해시코드 ]
         * hachCode 의 정수값은 두 객체의 내용이 다르면 "가급적" 다른 숫자가 나오도록 설계가 되어 있음
         * 21억...정수형 경우의 수를 넘어가면 똑같은 hashcode 값이 나올 수 있다.
         *
         * 1번 법칙) 만약 두 객체의 equals 반환값이 참(즉, 논리적으로 같은 객체)이라면 두 객체의 해시코드 값은 "반드시" 같아야 함
           2번 법칙) 비록 두 객체가 hashCode 메서드를 통해 똑같은 해시코드 값을 반환한다 해도, 해시값충돌(=hash collision)이 일어날 수 있기 때문에 두 객체가 논리적으로 같은 객체(equals 반환값이 참)라는 보장은 할 수 없음(같을 가능성이 높다)
         *  - 성능을 위해서 hashCode를 먼저 비교하는데, 두 객체의 hashCode가 다르면? => 두 객체가 논리적으로 다르다.
         *  - 두 객체의 hashCode가 같다?=> 두 객체가 논리적으로 같을 수 있으므로 equals메소드를 호출
         *
         * equals 메소드 할 때 hashCode()를 오버라이딩해서 최적화해 사용하는 것을 잊으면 안된다.
         *
         * [  깊은 복사(deep copy)와 얕은 복사(shallow copy)의 차이 ]
         * 필드 :  x - 100
         *        y - 200
         *       (*)p - kim
         *       (*)arr.[1,2,3]
         *
         * 복사를 하면 다른 곳에 똑같은 내용으로 복사된다.
         *        x - 100
         *        y - 200
         *       (*)p - kim
         *       (*)arr.[1,2,3]
         *

}
*/