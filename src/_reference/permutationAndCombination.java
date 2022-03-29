package _reference;

import java.util.Arrays;

public class permutationAndCombination {

    static int[] arr = {1, 2, 3, 4, 5};
    static int cnt = 0;
    public static void main(String[] args) {
//        rePermutation(0, arr, new int[3]);
//        permutation(0, arr, new int[3], new boolean[5]);
//        reCombination(0, 0, arr, new int[3]);
        combination(0, 0, arr, new int[3], new boolean[5]);
        System.out.println(cnt);
    }

    // 중복순열 n파이r = n^r
    public static void rePermutation(int idx, int[] origin, int[] result) {

        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            cnt++;
            return;
        }

        for (int i = 0; i < origin.length; i++) {
            result[idx] = origin[i];
            rePermutation(idx+1, origin, result);
        }
    }

    // 순열 nPr = n!/(n-r)!
    public static void permutation(int idx, int[] origin, int[] result, boolean[] visited) {

        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            cnt++;
            return;
        }

        for (int i = 0; i < origin.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = origin[i];
                permutation(idx+1, origin, result, visited);
                visited[i] = false;
            }
        }
    }

    // 중복조합 nHr = n+r-1Cr
    public static void reCombination(int idx, int originIdx, int[] origin, int[] result) {

        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            cnt++;
            return;
        }

        for (int i = originIdx; i < origin.length; i++) {
            result[idx] = origin[i];
            reCombination(idx+1, i, origin, result);
        }
    }

    // 조합 nCr = n!/r!(n-r)!
    public static void combination(int idx, int originIdx, int[] origin, int[] result, boolean[] visited) {

        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            cnt++;
            return;
        }

        for (int i = originIdx; i < origin.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = origin[i];
                combination(idx+1, i, origin, result, visited);
                visited[i] = false;
            }
        }
    }




}
