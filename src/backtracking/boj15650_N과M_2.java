package backtracking;

import java.util.Scanner;

public class boj15650_N과M_2 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        permutation(0, 1, new int[M]);
    }

    public static void permutation(int idx, int num, int[] arr) {

        if (idx >= arr.length) {
            for (int each : arr) System.out.print(each+" ");
            System.out.println();
            return;
        }

        for (int i = num; i <= N; i++) {
            arr[idx] = i;
            permutation(idx+1, i+1, arr);
        }
    }
}
