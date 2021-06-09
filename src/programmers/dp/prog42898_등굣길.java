package programmers.dp;

import java.util.HashSet;

public class prog42898_등굣길 {

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        final int mod = 1_000_000_007;

        int[][] dp = new int[n][m];
        HashSet<Integer> set = new HashSet<>();
        for (int[] each : puddles) {
            set.add((each[1]-1)*m+(each[0]-1));
        }

        for (int i = 0; i < n; i++) {
            if (set.contains(i*m)) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (set.contains(j)) break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (set.contains(i*m+j)) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        return dp[n-1][m-1];
    }
}
