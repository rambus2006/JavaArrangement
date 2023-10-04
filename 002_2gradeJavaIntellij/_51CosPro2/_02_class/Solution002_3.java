package _02_class;



/*========================================================
  2차 3번    2차 2급 3_initial_code.java
  ========================================================*/
// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution002_3 {
    public int solution(int N, int M) {
        // 여기에 코드를 작성해주세요.
        int answer=0;
        int sum=0;
        for(int i=N;i<M;i++){
            if(i%2==0)
                sum+=(i*i);

        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution002_3 sol = new Solution002_3();
        int N = 4;
        int M = 7;
        int ret = sol.solution(N, M);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}