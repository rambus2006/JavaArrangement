package _14StringBuffer;

/*학교에서는 진도가 천천히 꼼꼼히 나가므로 차라리 있는 서비스 주제 바꿔서 직접 만들어 보는 것을
* 추천한다. 문제푸는 것도 좋지만 db이런거 써서 만들어보는 것을 추천한다.
* 자바의 정석
* 인강 커리큘럼을 보고 검색해서 보고 공부하는 것도 좋다. 프로젝트를 만들면서 이런거 검색해서 보고 공부하면
* 좋다.
* */
import java.util.StringTokenizer;
import java.lang.StringBuffer; //StringBuffer 클래스 추가

public class StringBufferClass {
    public static void main(String[] args) {
        /*String result = "";
        for(int i=0;i<10;i++){
            result +=i+"";
        }
        System.out.println(result);*/
        String s = "abcd";
        StringBuffer sb = new StringBuffer("s"); //문자열을 만들어놔도 된다.
        StringBuffer sb2 = new StringBuffer(40); //원래는 적당한 capacity(배열크기)를 설정하지만 개발자가 직접 지정할 수도 있다.

        //[주요메소드]
        String s1="abcd";
        StringBuffer sb3=new StringBuffer(); //StringBuffer 생성
        //append메소드를 사용해 덧붙이기
        sb3.append("Hello"); //str 스트링을 스트링 버퍼에 덧붙인다.
        sb3.append("World"); //str 스트링을 스트링 버퍼에 덧붙인다.
        //아래는 새로 만드는 것
        //String  s2="Hello";
        //S2 +="World";
        sb3.append("abcdefdtertedwdrewtwerewrewrewrte"); //알아서 capacity의 크기를 늘린다.

        String s4="abcd";
        StringBuffer sb4=new StringBuffer();
        sb4.append("010234536");
        sb4.delete(1,3); //-1한 것 까지 지우기
        sb4.insert(1,"aa");
        System.out.println(sb4);
        sb4.insert(3,"bb");
        System.out.println(sb4);
        sb4.replace(1,3,"cccc"); //특정 위치에 cccc를 넣는다. (뒤의 bb와 같은 것은 뒤로 밀림->위치에만 넣는 것이기 때문에 )
        System.out.println(sb4);
        sb4.reverse(); //스트링 버퍼 내의 문자들을 반대 순서로 변경
        System.out.println(sb4);
        sb4.setLength(100); //capacity의 크기를 100으로 늘림, 문자열 외에는 null값이 들어간다.
        sb4.setLength(1); // 1글자만 나온다.(잘림) (9-아까 반전해서)
        System.out.println(sb4);

        //StringTokenizer 클래스
        String query = "name=kitae&addr=seoul&age=21";
        StringTokenizer st = new StringTokenizer(query, "&");//잘라낸 것을 토큰이라 한다.
        System.out.println(st.countTokens()); //토큰 3개
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken()); //name=...을 가져오면서 다음 순서의 토큰으로 넘어간다.
        }

        //Math클래스
        //실수 a의 sin값 리턴
        System.out.println(Math.sin(30*(Math.PI/180))); //삼각함수(단위가 라디안이라는 것을 조심해야 한다.)
        //E값 구하기
        System.out.println(Math.exp(1)); //e의 a승을 곱한값을 리턴
        System.out.println(Math.E); //E 값
        System.out.println(Math.ceil(0.1)); //1, 올림
        System.out.println(Math.floor(0.1)); //0, 내림
        System.out.println(Math.round(0.5)); //1, 반올림



    }
    //난수 발생
    public static int randomNumber(int n){
        return (int)Math.floor((Math.random()*n)+1);
    }

}
