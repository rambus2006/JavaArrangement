package _02_class;

public class Solution002_9_1 {
    public int[] solution(int[] votes, int N, int K) {
        int[] counter = new int[N + 1];

        // 득표수를 세는 부분은 그대로 유지
        for (int i = 0; i < votes.length; ++i)
            counter[votes[i]] += 1;

        int maxVotes = 0; // 가장 많은 득표수
        int minVotes = Integer.MAX_VALUE; // 가장 적은 득표수
        int maxCandidate = 0; // 가장 많은 득표자의 후보자 번호
        int minCandidate = 0; // 가장 적은 득표자의 후보자 번호

        for (int i = 1; i <= N; ++i) {
            if (counter[i] > maxVotes) {
                maxVotes = counter[i];
                maxCandidate = i;
            }
            if (counter[i] < minVotes) {
                minVotes = counter[i];
                minCandidate = i;
            }
        }

        int difference = maxVotes - minVotes; // 가장 득표수와 가장 적은 득표의 차이

        int[] result = { maxCandidate, minCandidate, difference };
        return result;
    }

    public static void main(String[] args) {
        Solution002_9 sol = new Solution002_9();
        int[] votes = { 2, 5, 3, 4, 1, 5, 1, 5, 5, 3 };
        int N = 5;
        int K = 2;
        int[] ret = new int[]{sol.solution(votes, N, K)};

        // 결과 출력
        System.out.println("가장 많은 득표자의 후보자 번호(MAX): " + ret[0]);
        System.out.println("가장 적은 득표자의 후보자 번호: " + ret[1]);
        System.out.println("가장 득표수와 가장 적은 득표의 차이: " + ret[2]);
    }
}
