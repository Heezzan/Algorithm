package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N+1];   // 무게
        int[] v = new int[N+1];   // 가치
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= w[i]) dp[i][j] = Math.max(v[i]+dp[i-1][j-w[i]], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}
