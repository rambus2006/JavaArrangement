package _14StringBuffer;
/*
* [String Buffer]
*  23-05-08 수업시간에 한 코드
*
* { 버퍼 }
* String a = "021345678" 문자열이 계속 만들었다 지웠다 하는 식
* 버퍼: 임시보관공간 (char 배열로 이루어져 있는)
*      일반적으로 1024~8000(8k)크기 사이의 버퍼를 많이 쓴다.
*      많은 양의 데이터를 한번에 저장할 수 있다.
* */

import java.util.StringTokenizer;

public class StringBufferEx{
    public static void main(String[] args){
        //Stringbuffer sb를 생성해 This를 넣는다. 길이는 16
        StringBuffer sb = new StringBuffer("This");
        //This 뒤에 is pencil 덧붙인다.
        sb.append(" is pencil"); //This is pencil (뒤에 is pencil 문자열 덧붙이기)
        //This is pencil 출력
        System.out.println(sb);
        //7번째 자리에 my를 삽입한다.
        sb.insert(7,"my"); //7번째 자리에 my 문자열 삽입
        //This is my pencil 출력
        System.out.println(sb);
        //8부터 10 자리인 my를 your로 대체
        sb.replace(8,10,"your"); //"my"를 "your"로 변경
        //This is your pencil 출력
        System.out.println(sb);
        //your 삭제
        sb.delete(8,13); //"your" 삭제
        //This is pencil 출력
        System.out.println(sb);
        //sb의 길이를 16 -> 4로 변경
        sb.setLength(4); //스트링 버퍼 내 문자열 길이 수정
        //This 출력
        System.out.println(sb); //sb.toString()으로 자동 바뀜
        //This Hello jump to java
        sb.append(" Hello jump to java");
        //this까지
        System.out.println(sb.substring(0, 4));
    }
}
