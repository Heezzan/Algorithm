package dp;

import java.util.Scanner;

public class boj11057_오르막수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int mod = 10007;
		
		int[][] dp = new int[N+1][10];
		for (int i = 0; i < 10; i++) 
			dp[1][i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < 10; i++) 
			result = (result + dp[N][i]) % mod;
		
		System.out.println(result);
	}

}
