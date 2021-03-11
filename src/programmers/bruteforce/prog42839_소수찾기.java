package programmers.bruteforce;

import java.util.Arrays;
import java.util.HashSet;

public class prog42839_소수찾기 {

    static boolean[] isPrime;
    static HashSet<Integer> nums;

    public int solution(String numbers) {
        int answer = 0;

        isPrime = new boolean[10_000_000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < 10_000; i++) {
            if (isPrime[i]) {
                for (int j = 2; i*j < isPrime.length; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i)-'0';
        }

        nums = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            perm(0, arr, new int[i+1], new boolean[numbers.length()]);
        }

        for (int n : nums) {
            if (isPrime[n]) answer++;
        }

        return answer;
    }

    public void perm (int idx, int[] origin, int[] result, boolean[] visited) {
        if (idx >= result.length) {
            int num = 0;
            for (int i = 0; i < result.length; i++) {
                num *= 10;
                num += result[i];
            }

            nums.add(num);
            return;
        }

        for (int i = 0; i < origin.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = origin[i];
                perm(idx+1, origin, result, visited);
                visited[i] = false;
            }
        }
    }
}
