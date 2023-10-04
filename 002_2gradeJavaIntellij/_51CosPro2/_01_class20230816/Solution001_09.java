package _01_class20230816;

/*========================================================
  1차 9번    1차 2급 9_initial_code.java
  ========================================================*/
class Solution001_09 {
    public String solution(String characters){
        String result = "";
        //방법1
        // 문자열을 순회하면서 현재 문자와 다음 문자를 비교하여 중복을 제거합니다.
        for (int i = 0; i < characters.length() - 1; i++) {
            // 현재 문자와 다음 문자가 다르면 중복이 아니므로 결과 문자열에 추가합니다.
            if (characters.charAt(i) != characters.charAt(i + 1)) { //i와 i-1을 비교한다.
                result += characters.charAt(i);
            }
        }
//        result += characters.charAt(0);
//        for (int i = 0; i < characters.
//        length()+1; i++) {
//            if (characters.charAt(i) != characters.charAt(i+1))
//                result += characters.charAt(1);
//        }
//        for(int i=0;i<characters.length()-1;i++){
//            if(characters.charAt(i) != characters.charAt(i+1))
//                result +=characters.charAt(i);
//        }
        return result;

    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution001_09 sol = new Solution001_09();
        String characters = "senteeeencccccceeee.";
        String ret = sol.solution(characters);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}