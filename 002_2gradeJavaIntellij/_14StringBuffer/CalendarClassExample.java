package _14StringBuffer;
import java.util.Calendar;
import java.util.Date;

//[Calendar 클래스의 특징]
/* 1. 시간과 날짜 정보 저장 관리
* - 년,월,일,요일,시간,분,초,밀리초,오전 오후 등
* - Calendar 클래스의 각 시간 요소를 설정하기나 알아내기 위한 필드들
*       필드      |      의미       |
*       YEAR     | 년도
*       MONTH    | 달(0~11)
*       HOUR     | 시간(0~11)
*    HOUR_OF_DAY | 24시간을 기준으로 한시간
*    SECOND      | 초
*   DAY_OF_MONTH | 한달의 날짜
*   DAY_OF_WEEK  | 한 주의 요일
*   AM_PM        | 오전인지 오후인지 구분
*   MINUTE       | 분
*  MILLISECOND   | 밀리초
*
* 2. Calendar now = Calendar.getInstance();
*   - now 객체는 현재 날짜와 시간 정보를 가지고 생성
*   - Calendar 는 추상클래스 이므로 new Calendar() 하지 않음
*
* 3. 날짜와 시간 알아내기
*   int year = now.get(Calendar.YEAR);  //now 에 저장된 년도
*   int month = now.get(Calendar.MONTH)+1; //now에 저장된 달
*
* 4. 날짜와 시간 설정하기
* - Calendar 객체에 저장 : Calendar 객체에 날짜와 시간을 저장한다고 컴퓨터의 날짜와 시간을 바꾸는 것은 아님
*   //이성 친구와 처음으로 데이트한 날짜와 시간 저장
*   Calendar firstDate = Calendar.getInstance();
*   firstDate.clear(); //현재 날짜와 시간 정보를 모두 지운다.
*   firstDate.set(2016,11,25); //2016년 12월 25일. 12월은 11로 설정
*   firstDate.set(Calendar.HOUR_OF_Day,20); //저녁 8시로 설정
*   firstDate.set(Calendar.MINUTE,30); //30분으로 설정
*
* */
public class CalendarClassExample {
    public static void main(String args[]) {
        Date now = new Date();
    // 추상 클래스 Calendar 사용하여 날짜 및 시간 받아오기 가능
    // Calendar의 싱글턴 객체를 받아오기 (현재 시간을 기준으로 캘린더 객체가 생성됨)
        Calendar c = Calendar.getInstance();
    // 먼저 날짜 객체를 이용하여 캘린더 인스턴스의 날짜를 설정 가능
        c.setTime(now);
    // 날짜 및 시간 출력
        System.out.println("YEAR : " + c.get(Calendar.YEAR));
// 년
        System.out.println("MONTH : " + (c.get(Calendar.MONTH) + 1));
// 월 (월의 경우 리턴값의 범위는 0~11 따라서 1을 더해줘야 함)
        /*LocalDate, LocalDateTime 클래스
        java.time 패키지 소속의 클래스로 1.8버전부터 추가된 표준 날짜, 시간용 클래스
        기존의 Date 클래스 대신 사용이 권장됨*/
        System.out.println("DAY_OF_MONTH : " + c.get(Calendar.DAY_OF_MONTH));
// 한 달 중의 날짜
        System.out.println("HOUR : " + c.get(Calendar.HOUR));
// 시
        System.out.println("MINUTE : " + c.get(Calendar.MINUTE));
// 분
        System.out.println("SECOND : " + c.get(Calendar.SECOND));
// 초
        System.out.println("MILLISECOND : " + c.get(Calendar.MILLISECOND));
// 밀리초
        System.out.println("HOUR_OF_DAY : " + c.get(Calendar.HOUR_OF_DAY));
// 24시간제를 기준으로 한 시간
        System.out.println("DAY_OF_WEEK : " + c.get(Calendar.DAY_OF_WEEK));
// 한 주의 요일 (일요일부터 1, 토요일이 7)
        System.out.println("AM_PM : " + (c.get(Calendar.AM_PM) == Calendar.AM));
// AM_PM => 오전, 오후 여부(AM, PM 상수와 비교)
    }

}
