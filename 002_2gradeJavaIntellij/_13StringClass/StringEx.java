package _13StringClass;

/*
* [String 클래스]
* - java.lang 패키지에 포함되어 있다.
* - String 클래스는 하나의 문자열 표현
* - String 객체는 수정이 불가능하다.
* - String 비교 시 반드시 equals()를 사용: equals()내용을 비교하기 때문
* <String 클래스 생성 방법>
* (1) 리터럴로 생성, String s="Hello";
* -JVM이 리터럴 관리, 응용프로그램 내에서 공유됨
* (2) String 객체로 생성,String t=new String("Hello");
* -힙 메모리에 String 객체 생성
* <String class 주요 메소드 >
* char charAt(int index):index 인덱스에 있는 문자 값 리턴
* int codePointAt(int index):index인덱스에 있는 유니코드 값 리턴
* int compareTo(String another String): 두 스트링을 사전 순으로 비교하여 두 스트링이 같으면 0,
*                                       현 스트링이 anotherStirng 보다 먼저 나오면 음수, 아니면 양수 리턴
* String concat(String str): 현재 스트링 뒤에 str스트링을 덧붙인 새로운 스트링 리턴
* boolean contains(CharSequence s):s에 지정된 문자들을 포함하고 있으면 true 리턴
* int length(): 스트링 길이(문자 개수)flxjs
* String replace(Charsequence target,Charsequence replacement): target이 지정하는 일련의 문자들을 replacement가 지정하는 문자들로 변경한
*                                                                스트링 리턴
* Stirng[] split(String regex): 정규식regex에 일치하는 부분을 중심으로 스트링을 분리하고,분리된 스트링들을 배열로 저장하여 리턴
* String subString(int beginIndex): beginIndex인덱스 부터 시작하는 서브 스트링 리턴
* String toLowerCase():소문자로 변경한 스트링 리턴
* Stirng toUpperCase():대문자로 변경한 스트링 리턴
* Stirng trim():스트링 앞뒤의 공백 문자들을 제거한 스트링 리턴
*/
public class StringEx {
    public static void main(String[] args) {
        String a = new String("C#");
        String b =new String(",C++");

        System.out.println(a+"의 길이는 "+a.length()); //문자열의 길이
        System.out.println(a.contains("#")); //문자열의 포함관계

        a = a.concat(b); //문자열 연결
        System.out.println(a);

        a= a.trim(); //문자열 앞 뒤의 공백 제거
        System.out.println(a);

        a=a.replace("C#","Java"); //문자열 대치
        System.out.println(a);

        String s[] = a.split(","); //문자열 분리
        for(int i=0;i<s.length;i++)
            System.out.println("분리된 문자열" + i + ":" + s[i]);
        a = a.substring(5); //인덱스 5부터 끝까지 서브 스트링 리턴
        System.out.println(a);

        char c = a.charAt(2); //인덱스 2의 문자 리턴
        System.out.println(c);
    }
}
