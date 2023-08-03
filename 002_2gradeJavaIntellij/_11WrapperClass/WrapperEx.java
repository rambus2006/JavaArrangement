package _11WrapperClass;

import java.awt.*;

/*
* [wrapper클래스]
*  1. 자바의 기본 타입을 클래스화한 8개 클래스
*  2. 이름이 wrapper인 클래스는 존재하지 않는다.
*  3. 앞글자를 대문자로 바꾸면 된다. (int -> integer, char -> Character)
*  4. 오토박싱을 이용하여 객체 생성 가능
*  5. 용도: 기본 타입의 값을 객체로 다룰 수 있게 함
*   byte - Byte
*   short - Short
*   int - Integer
*   long - Long
*   char -Character
*   float - Float
*   double - Double
*   boolean - Boolean
*
* <주요 메소드>
* - Wrapper 객체들은 거의 유사, 많은 메소드가 static 타입
* - Integer 클래스의 주요 메소드
* static int bitCount : 정수 i의 이진수 표현에서 1의 개수 리턴
* float floatValue() : float 타입으로 값 리턴
* int intValue() : int 타입으로 값 리턴
* long longValue() : long 타입으로 값 리턴
* short shortValue() : short 타입으로 값 리턴
* static int parseInt(String s) : 문자열 s를 10 진 정수로 변환한 값 리턴
* static int parseInt(String s,int radix) : 문자열 s를 지정된 진법의 정수로 변환한 값 리턴
* static String toBinaryString(int i): 정수 i를 이진수 표현으로 변환한 문자열 리턴
* static String toHexString(int i): 정수 i를 이진수 16진수 표현으로 변환한 문자열 리턴
* static String toOctalString(int i): 정수 i를 8진수 표현으로 변환한 문자열 리턴
* static String toString(int i): 정수 i를 문자열로 변환하여 리턴
* static Integer valueOf(int i): 정수 i를 담은 Integer객체 리턴
* static Integer valueOf(String s) : 문자열 s를 정수로 변환하여 담고 있는 Integer객체 리턴
*
* [wrapper클래스 활용]
* 다음은 wrapper클래스를 활용하는 예이다. 다음 프로그램의 결과는 무엇인가?
* */
public class WrapperEx {
    public static void main(String[] args) {
        System.out.println(Character.toLowerCase('A')); //wrapper클래스:'A'를 소문자로 변환
        char c1='4',c2='F';
        if(Character.isDigit(c1)) //문자 c1이 숫자이면 true
            System.out.println(c1+"는 숫자");
        if(Character.isAlphabetic(c2)) //문자 c2가 영문자이면 true
            System.out.println(c2+"는 영문자");
        System.out.println(Integer.parseInt("-123")); //"-123"을 10진수로 변환
        System.out.println(Integer.toHexString(28)); //정수 28을 16진수 문자열로 변환
        System.out.println(Integer.toBinaryString(28)); //정수 28을 이진수 표현으로 변환한 문자열 리턴
        System.out.println(Integer.bitCount(28)); //28에 대한 2진수의 1의 개수

        Double d = Double.valueOf(3.14); //3.14를 문자열 String 객체로 변환
        System.out.println(d.toString()); //double을 문자열 "3.14"로 반환
        System.out.println(Double.parseDouble("3.14")); //문자열을 실수 3.14로 변환


        boolean b = (4>3);
        System.out.println(Boolean.toString(b));//true를 문자열 "true"로 변환
        System.out.println(Boolean.parseBoolean("false")); //문자열을 false로 변환
    }
}
