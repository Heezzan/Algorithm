package programmers.sort;

import java.util.Arrays;

public class prog42747_H_index {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{88, 89}));
    }

    public static int solution(int[] citations) {
        // n편 중, h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었을 때의 최댓값
        Arrays.sort(citations);

        int[] accum = new int[citations[citations.length-1]+1];
        for (int i = 0; i < citations.length; i++) {
            accum[citations[i]]++;
        }

        for (int i = 0; i < accum.length-1; i++) {
            accum[i+1] += accum[i];
        }

        int len = accum.length-1;
        for (int i = len; i > 0; i--) {
            if (accum[len]-accum[i-1] >= i
                    && accum[i-1] <= i) {
                return i;
            }
        }
        return 0;
    }
}
