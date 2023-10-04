package _03_class230912;


/*========================================================
  3차 5번    3차 2급 5_initial_code.java
  ========================================================*/
class Solution003_5 {
    public int solution(int[] memberAge, String transportation) {
        int adultExpense = 0;
        int childExpense = 0;

        if(transportation.equals("Bus")) {
            adultExpense = 40000;
            childExpense = 15000;
        }
        else if(transportation.equals("Ship")) {
            adultExpense = 30000;
            childExpense = 13000;
        }
        else if(transportation.equals("Airplane")) {
            adultExpense = 70000;
            childExpense = 45000;
        }
        //여행객들이 10명 이상인 경 이상인경우
        if(memberAge.length >= 10) {
            adultExpense =(int)(adultExpense * 0.9);
            childExpense =(int)(adultExpense * 0.8);
        }

        int totalExpenses = 0;
        for(int i = 0; i < memberAge.length; i++) {
            //성인 요금 따로 합계 조회, 자식 요금 합계 조회하는 if문
            if(memberAge.length>=20)
                totalExpenses += adultExpense;
			else
                totalExpenses += childExpense;
        }

        return totalExpenses;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution003_5 sol = new Solution003_5();
        int[] memberAge1 = {13, 33, 45, 11, 20};
        String transportation1 = "Bus";
        int ret1 = sol.solution(memberAge1, transportation1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] memberAge2 = {25, 11, 27, 56, 7, 19, 52, 31, 77, 8};
        String transportation2 = "Ship";
        int ret2 = sol.solution(memberAge2, transportation2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}