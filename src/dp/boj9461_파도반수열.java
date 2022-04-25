package dp;

import java.util.Scanner;

public class boj9461_파도반수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        long[] dp = new long[100+1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}
