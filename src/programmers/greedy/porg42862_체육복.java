package programmers.greedy;

import java.util.Arrays;

public class porg42862_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] cnt = new int[n+1];
        Arrays.fill(cnt, 1);

        for (int i = 0; i < lost.length; i++) {
            cnt[lost[i]]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            cnt[reserve[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (cnt[i] > 0) answer++;
            else {
                if (i > 1 && cnt[i-1] == 2) answer++;
                else if (i < n && cnt[i+1] == 2) {
                    cnt[i+1]--;
                    answer++;
                }
            }
        }

        return answer;
    }
}
