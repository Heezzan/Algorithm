package dp;

import java.util.Scanner;

public class boj11726_2xn타일링 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int mod = 10007;
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 1;
		if (n >= 2)	dp[2] = 2;	// n이 1일때 dp의 인덱스가 0~1인데 dp[2]에 접근해서 런타임에러!

		for (int i = 3; i <= n; i++) 
			dp[i] = (dp[i-2] + dp[i-1]) % mod;
		
		System.out.println(dp[n]);
		
	}

}
