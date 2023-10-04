package _01_class20230816;

public class Solution001_04 {
    int[] func_a(int[] arr){
        int[] counter = new int[1001];
        for(int i = 0; i < arr.length; i++)
            counter[arr[i]]++;
        return counter;
    }
    //최댓값
    int func_b(int[] arr){
        int ret = 0;
        for(int i = 0; i < arr.length; i++){
            if(ret < arr[i])
                ret = arr[i];
        }
        return ret;
    }

    //최소값
    int func_c(int[] arr){
        final int INF = 1001;
        int ret = INF;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && ret > arr[i]) //출현하지 않은수
                ret = arr[i];
        }
        return ret;
    }
    public int solution(int[] arr) {
        int[] counter = func_a(arr);
        int maxCnt = func_b(counter);
        int minCnt = func_c(counter);
        return maxCnt / minCnt;

        //반장 후보 풀기

    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution001_04 sol = new Solution001_04();
        int[] arr = {1, 2, 3, 3, 1, 3, 3, 2, 3, 2,4,4,5,5,5,1,2,3,4};
        int ret = sol.solution(arr);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
