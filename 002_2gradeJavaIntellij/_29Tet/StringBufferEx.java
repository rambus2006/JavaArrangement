package _29Tet;
public class StringBufferEx{
    public static void main(String[] args){
        //Stringbuffer sb를 생성해 This를 넣는다. 길이는 16
        StringBuffer sb = new StringBuffer("This");
        //This 뒤에 is pencil 덧붙인다.
        sb.append(" is pencil"); //This is pencil (뒤에 is pencil 문자열 덧붙이기)
        //This is pencil 출력
        System.out.println(sb);
        //7번째 자리뒤에 my를 삽입한다.
        sb.insert(7," my"); //7번째 자리뒤에 my 문자열 삽입
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
