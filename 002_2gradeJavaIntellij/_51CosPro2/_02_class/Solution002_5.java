package _02_class;

/*========================================================
  2차 5번    2차 2급 5_initial_code.java
  ========================================================*/
class Solution002_5 {
    public int solution(int attack, int recovery, int hp) {
        int count = 0;
        while(true){
            count += 1;
            hp -= attack;
            if(hp <= 0)
                break;
            hp += recovery;
        }
        return count;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution002_5 sol = new Solution002_5();
        int attack = 30;
        int recovery = 10;
        int hp = 60;
        int ret = sol.solution(attack, recovery, hp);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}