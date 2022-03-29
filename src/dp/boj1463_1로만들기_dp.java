package dp;

import java.util.Scanner;

public class boj1463_1로만들기_dp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int[] dp = new int[1_000_001];
        dp[2] = dp[3] = 1;

        for (int i = 4; i <= X; i++) {

            if (i % 2 == 0 && i % 3 == 0) dp[i] = Math.min(Math.min(dp[i/2], dp[i/3]), dp[i-1])+1;
            else if (i % 2 == 0) dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            else if (i % 3 == 0) dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            else dp[i] = dp[i-1] + 1;
        }

        System.out.println(dp[X]);
    }
}
