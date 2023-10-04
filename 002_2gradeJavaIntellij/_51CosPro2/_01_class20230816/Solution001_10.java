package _01_class20230816;

/*========================================================
  1차 10번    1차 2급 10_initial_code.java
  ========================================================*/
class Solution001_10 {
    public int solution(int[] data) {
        double total = 0;
        int len = data.length;
        //평균 구하기
        for(int i = 0; i < len; i++)
            total += data[i];
        int cnt = 0;
        double average = total/len;
        //평균 이하의 개수를 출력
        for(int i = 0; i < len; i++)
            if (data[i] <= average)
                cnt += 1;
        return cnt;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution001_10 sol = new Solution001_10();
        int[] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int ret1 = sol.solution(data1);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int[] data2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 10};
        int ret2 = sol.solution(data2);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}
