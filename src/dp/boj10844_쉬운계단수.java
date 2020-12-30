package dp;

import java.util.Scanner;

public class boj10844_쉬운계단수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int mod = 1000000000;
		
		int[][] dp = new int[N+1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j != 0) 
					dp[i][j] += dp[i-1][j-1];
				if (j != 9)
					dp[i][j] += dp[i-1][j+1];
				
				dp[i][j] %= mod;
			}
		}
		
		int result = 0;
		for (int i = 0; i < 10; i++) 
			result  = (result + dp[N][i]) % mod;
		
		System.out.println(result);
	}
}
