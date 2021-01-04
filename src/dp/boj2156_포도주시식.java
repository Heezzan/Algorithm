package dp;

import java.util.Scanner;

public class boj2156_포도주시식 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] wine = new int[N];
		for (int i = 0; i < N; i++) 
			wine[i] = sc.nextInt();
		
		int[][] dp = new int[N][3];
		dp[0][1] = wine[0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);	// dp[i-1][0]까지 넣는 경우를 빼먹었다... 근데 왜...?
			dp[i][1] = dp[i-1][0] + wine[i];
			dp[i][2] = dp[i-1][1] + wine[i];
		}
		
		System.out.println(Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
		
	}

}
