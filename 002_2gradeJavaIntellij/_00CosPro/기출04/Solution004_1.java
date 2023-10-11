package _04_class231004;

import java.util.Arrays;


/*=======================================================
 * 4차시 1번 : 4차 2급 1_initial_code.java
 =========================================================*/
class Solution004_1 {
    public int[] solution(String[] schedule) {
        int xCount = 0;
        for(int i=0; i<10; i++)
            if(schedule[i].charAt(0) == 'X') //x의 개수 세기
                xCount++;

        int[] answer = new int[xCount]; //x의 개수만큼 배열 생성
        for(int i=0, j=0; i<10; i++) { //전체 루프 돌기
            if(schedule[i].charAt(0) == 'X') { // 만약 x값인것
                answer[j++] = i+1;
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution004_1 sol = new Solution004_1();
        String[] schedule = {"O", "X", "X", "O", "O", "O", "X", "O", "X", "X"};
        int[] ret = sol.solution(schedule);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.print("solution 메소드의 반환 값은 ");
        System.out.printf(Arrays.toString(ret));
        System.out.println(" 입니다.");
    }
}