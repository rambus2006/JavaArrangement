package _01_class20230816;
//안풀리는 문제
public class Solution001_06 {
    public int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) { //1부터 40 까지
            int current = i;  //박수치는 최수
            int temp = count;
            while (current != 0) {
                if (i%10==3||current%10==6||current%10==9){
                    count++;
                    System.out.print("pair");
                }
                current /= 10;
            }
            if(temp == count)
                System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        return count;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution001_06 sol = new Solution001_06();
        int number = 40;
        int ret = sol.solution(number);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
