package dp;

import java.util.Scanner;

public class boj9095_123더하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] dp = new int[12];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			
			if (dp[n] > 0) {
				System.out.println(dp[n]);
			} else {
				for (int i = 4; i <= n; i++) {
					dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				}
				System.out.println(dp[n]);
			}
		}
	}

}
