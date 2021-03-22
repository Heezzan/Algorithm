package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15486_퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cal = new int[N+1][2];
        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cal[i][0] = Integer.parseInt(st.nextToken());
            cal[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp= new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i]);
            if (i+cal[i][0]-1 <= N)
                dp[i+cal[i][0]-1] = Math.max(dp[i+cal[i][0]-1], dp[i-1]+cal[i][1]);
        }

        System.out.println(dp[N]);
    }
}
