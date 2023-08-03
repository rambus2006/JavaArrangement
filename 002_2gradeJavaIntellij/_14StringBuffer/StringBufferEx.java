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

public class StringBufferEx {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("This");
        sb.append("is poencil"); //문자열 덧붙이기
        System.out.println(sb);
        sb.insert(7,"my"); //문자열 삽입
        System.out.println(sb);
        sb.replace(8,10,"your"); //'my'를 'your'로 변경
        System.out.println(sb);
        sb.delete(8,13); //"your" 삭제
        System.out.println(sb);
        sb.setLength(4); //스트링 버퍼 내 문자열 길이 수정
        System.out.println(sb); //sb.toString()으로 자동 바뀜
    }

}
