package _12Boxing;
/*
* [박싱과 언박식]
* -박싱: 기본 타입의 값을 Wrapper 객체로 바꾸는 것
* ex) int -> Integer
* -언박싱: Wrapper 객체에 들어있는 기본 타입의 값으로 바꾸는 것
* ex) 데이터타입(대문자) 변수명 = 데이터 타입.valueOf();
* -변수에 값을 대입하면 오토박싱에 의해 자동으로 박싱이 되기 때문에 거의 쓰지 않는다.
* */
public class AutoBoxingUnBoxingEx {
    public static void main(String[] args) {
        int n=10;
        Integer intObject = n; //오토 언박싱
        System.out.println("intObject = "+intObject);
        int m = intObject+10; //오토 언박싱
        System.out.println("m = "+m);
    }
}
