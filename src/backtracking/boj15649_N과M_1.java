package backtracking;

import java.util.Scanner;

public class boj15649_N과M_1 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        permutation(0, new int[M], new boolean[N+1]);

    }

    public static void permutation(int idx, int[] arr, boolean[] visited) {

        if (idx >= arr.length) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                permutation(idx+1, arr, visited);
                visited[i] = false;
            }
        }
    }
}
