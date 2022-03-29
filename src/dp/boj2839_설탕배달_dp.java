package dp;

import java.util.Scanner;

public class boj2839_설탕배달_dp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[5_000+1];
        dp[3] = dp[5] = 1;

        for (int i = 6 ; i <= N; i++) {
            if (dp[i-3] != 0 && dp[i-5] != 0) dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            else if (dp[i-3] != 0) dp[i] = dp[i-3] + 1;
            else if (dp[i-5] != 0) dp[i] = dp[i-5] + 1;
        }


        System.out.println(dp[N] == 0 ? "-1" : dp[N]);
    }
}
