여기는 java 수업이나 java 관련 코드가 올라오는 곳입니다. 
---
#깃 커밋하는 법
---
cmd에서 하는 방법>
1. cd 로 해서 경로를 맞춰준다. 
2. git add (폴더명 또는 .(전체를 의미))로 해서 git에 올릴 파일 설정
3. git commit -m "커밋 메시지" 로 해서 커밋해주기 
4. 한번 확인 (git status)
5. push해서 github에 올리기 
  명령어: git push -u origin master (저장소명) (브랜치명)

기타 명령어><br/>
- pull 해서 가져오기: git pull origin main


#개념정리 
---
- java개념정리(노션) : <https://www.notion.so/rambus06/JAVA-301d2f8912074eeeabea96abbd777f52?pvs=4>
- java개념정리(네이버블로그) : <https://blog.naver.com/PostList.naver?blogId=rambus06&categoryNo=104&from=postList>

#목차
---
<br/><2학년 수업과정>
<br/>[001_클래스 상속](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_01Class_inheritance) - 클래스끼리의 상속
<br/>[002_super키워드](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_02Super) - 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는 데 사용하는 참조 변수
<br/>[003_Upcasting](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_03Upcasting) - 업캐스팅,자식 클래스의 객체 -> 부모 클래스 타입으로 형변환 
<br/>[004_Downcasting](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_04Downcasting) - 다운캐스팅,부모 클래스의 객체 -> 자식 클래스 타입으로 형변환 (업캐스팅과 반대)
<br/>[005_InstanceOf](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_05InstanceOf) - 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인하는데 사용하는 연산자
<br/>[006_MethodOverRiding](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_06MethodOverRiding) - 메소드 오버라이딩, 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의하여 사용하는 것
<br/>[007_AbstractMethod](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_07AbstractMethod) - 추상메소드,자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드
<br/>[008_Interface](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_08Interface) - 인터페이스,다른 클래스를 작성할 때 기본이 되는 틀을 제공, 다른 클래스 사이의 중간 매개 역할까지 담당하는 추상 클래스
<br/>[009_Package](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_09Package) - 패키지,클래스와 인터페이스의 집합
<br/>[010_ObjectClass](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_10ObjectClass) - Object클래스,java의 최대 조상클래스
<br/>[011_WrapperClass](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_11WrapperClass) - Wrapper클래스, 기본자료타입(int,String등)을 객체로 다룰 때 사용하는 클래스 
<br/>[012_Boxing](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_12Boxing) - 박싱,기본 자료형의 데이터를 래퍼(wrapper) 클래스의 객체로 만드는 과정
<br/>[013_StringClass](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_13StringClass) - String클래스,java.lang.String 클래스
<br/>[014_StringBuffer](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_14StringBuffer) - 상시 바뀌는 문자열을 처리하기 위한 클래스 
<br/>[015_HashCode](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_15HashCode) - 해시코드,객체를 식별하는 하나의 정수값
<br/>[016_Generic](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_16Generic) - 제네릭,클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법(수업시간코드)
<br/>[017_Collection](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_17Collection) - 컬렉션,목록성 데이터를 처리하는 자료구조
<br/>[018_ArrayList](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_18ArrayList) - 여러 데이터를 순서대로 관리하고 싶을 때 사용
<br/>[019_PerforomTest](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_19PerformTest) - 수행평가
<br/>[020_main(수업시간에 한 것)](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_20Main_방민서_2305)
<br/>[021_ComparableInterface](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_21Comparable인터페이스) - 객체 정렬에 사용
<br/>[022_Generic2](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_22Generic) - 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법(명품자바 + 혼공자바)
<br/>[023_JavaUtilPackage](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_23JavaUtilPackage) - java.util 패키지 
<br/>[024_ArrayListTest](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_24ArrayList문제)
<br/>[025_Stream](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_25Stream) - 스트림,단일 방향으로 연속적으로 흘러가는 것
<br/>[026_in&output](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_26입출력) - 입출력스트림, 파일읽는 스트림 
<br/>[027_ThreadStudy](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_27_thread_study) - 스레드
<br/>[028_FileClass](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_28파일클래스) - 파일클래스,파일의 경로명을 다루는 클래스 
<br/>[029_Thread](https://github.com/rambus2006/JavaArrangement/tree/main/002_2gradeJavaIntellij/_29_%EC%8A%A4%EB%A0%88%EB%93%9C)- 스레드 

#테트리스[003_Tetris](https://github.com/rambus2006/JavaArrangement/tree/main/_003_Tetris)
---
<br/>[테트리스](https://github.com/rambus2006/JavaArrangement/tree/main/_003_Tetris)

#피자가게키오스크 
---
<br/>[피자가게키오스크 프로젝트]()

#스프링
---
<br/>[스프링 핵심 원리 - 기본편(01~03)](https://github.com/rambus2006/JavaArrangement/tree/main/main/java/hello/core)
