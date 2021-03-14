package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) dp[i][i] = true;
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for (int k = 3; k <= N; k++) {
            for (int i = 1; i <= N-k+1; i++) {
                int j = i+k-1;
                if (arr[i] == arr[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end] ? 1 : 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
