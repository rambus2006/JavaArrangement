package _01_class20230816;

import java.util.*;
public class Solution001_05 {
    public int[] solution001_05(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right -= 1;
        }
        return arr;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution001_05 sol = new Solution001_05();
        int[] arr = {1, 4, 2, 3};
        int[] ret = sol.solution001_05(arr);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret) + " .");
    }
}
