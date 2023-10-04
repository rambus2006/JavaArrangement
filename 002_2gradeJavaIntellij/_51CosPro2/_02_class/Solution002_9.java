package _02_class;

/*========================================================
  2차 9번    2차 2급 9_initial_code.java
  ========================================================*/
//1) 가장 많은 득표자의 후보자 번호(MAX)
//2) 가장 적은 득표자의 후보자 번호
//3) 가장 득표수와 가장 적은 득표의 차이를 출력
class Solution002_9 {
    public int solution(int[] votes, int N, int K) {
        //각 후보자의 득표수를 저장하는 배열을 생성
        int[] counter = new int[N + 1];
        int max=0; //득표수 중 최대값을 저장할 변수
        //투표 결과를 반복하여 처리한다.
        for(int i = 0; i < votes.length; ++i){
            max=counter[votes[i]]; //현재 후보자의 득표수를 max 변수에 저장
            counter[votes[i]] += 1; //현재 후보자의 득표수를 1 증가
        }

//        int answer = -1;
        int answer=0; //조건에 맞는 후보자 수를 세기 위한 변수
        //후보자들의 득표수를 확인하면서 조건에 맞는 후보자 수를 세어준다.
        for(int i = 0; i <= N; ++i)
            if(counter[i] == K)
                answer += 1; //조건에 맞는 득표수를 가진 후보자를 발견하면 answer를 1 증가
        return answer; //조건에 맞는 후보자 수를 반환
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Solution002_9 sol = new Solution002_9();
        int[] votes = {2, 5, 3, 4, 1, 5, 1, 5, 5, 3};
        int N = 5;
        int K = 2;
        int ret = sol.solution(votes, N, K);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret +  " 입니다.");
    }
}