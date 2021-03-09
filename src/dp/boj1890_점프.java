package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1890_점프 {

    // 보자마자 bfs+dp로 풀었더니 메모리초과, 재귀+dp로 풀었더니 시간초과...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                if (i+map[i][j] < N) dp[i+map[i][j]][j] += dp[i][j];
                if (j+map[i][j] < N) dp[i][j+map[i][j]] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
