package _04_class231004;


/*=======================================================
 * 4차시 4번 : 4차 2급 4_initial_code.java
 =========================================================*/
class Solution004_4 {
    public int Solution004_4(int[] classes, int m) {
        int answer = 0;
        for(int i=0; i<classes.length; i++) {
            answer += classes[i] / m;
            if (classes[i] % m != 0)
            answer++;
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution004_4 sol = new Solution004_4();
        int[] classes = {80, 45, 33, 20};
        int m = 30;
        int ret = sol.Solution004_4(classes, m);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}