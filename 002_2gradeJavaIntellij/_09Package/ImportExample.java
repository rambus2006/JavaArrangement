package _09Package; //패키지 만들기 - 형식: package 패키지명;
                    //컴파일 한 클래스 파일을 패키지 명의 디렉토리에 저장하라는 지시
                    //소스파일의 첫줄에 선언
import java.util.Scanner; //소스 시작 부분에 사용하려는 패키지 명시, 특정 클래스의 경로명만 포함
import java.util.*; //패키지 내의 모든 크래스 포함(현재 패키지 내의 클래스만을 의미하며 하위 패키지의 클래스까지 포함하지 않는다.)

/*
* [package]
- 서로 관련된 크래스와 인터페이스의 컴파일 될 클래스 파일들을 하나의 디렉토리에 묶어놓은 것
- 패키지 명과 클래스의 경로명: 점(.)으로 연결
* ex) Project.FileO.Tools.class
*     Project.UI.Tools.class
* <패키지 사용>
 - 다른 패키지에 작성된 클래스 사용
 * (1)import를 사용하지 않은 경우: 소스 내에서 패키지 이름과 클래스 이름의 전체 경로명을 써줘야 한다.
 * (2)import를 사용하는 경우: - 소스의 시작 부분에 사용하려는 패키지 명시(소스에는 클래스 명만 명시하면 됨)
 *                         - 특정 클래스의 경로명만 포함
 *                         * 패키지 내의 모든 클래스 포함( import java.util.*;)
 *                         *은 현재 패키지 내의 클래스만을 의미하며 하위 패키지의 클래스까지 포함하지 않는다.
 * <패키지 만들기>
 1. 패키지 선언v
 * -형식 : package 패키지명;
 * -컴파일한 클래스 파일을 패키지 명의 디렉토리에 저장하라는 지시
 * -소스파일의 첫줄에 선언
*/
//import를 사용하지 않은 경우
public class ImportExample {
    public static void main(String[] args) {
        java.util.Scanner scanner= new java.util.Scanner(System.in); //소스 내에서 패키지 이름과 클래스 이름의 전체 경로명을 써줘야 한다.
        System.out.println(scanner.next());
    }
}
//import를 사용한 경우
class ImportExample2{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in); //소스에는 클래스 명인 Scanner만 명시
    }
}
//*을 사용한 경우
class ImportExample3{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
    }
}
