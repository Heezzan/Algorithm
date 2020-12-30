package dp;

import java.util.Scanner;

public class boj11727_2xn타일링2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int mod = 10007;
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		if (n >= 2)	dp[2] = 3;
		
		for (int i = 3; i <= n; i++) 
			dp[i] = (dp[i-1] + dp[i-2]*2) % mod;
		
		System.out.println(dp[n]);
	}

}
