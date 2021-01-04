package dp;

import java.util.Scanner;

public class boj2579_계단오르기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stairs = new int[N];
		for (int i = 0; i < N; i++)
			stairs[i] = sc.nextInt();
		
		int[][] dp = new int[N][3];
		dp[0][1] = stairs[0];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);	
			dp[i][1] = dp[i-1][0] + stairs[i];
			dp[i][2] = dp[i-1][1] + stairs[i];
		}
		
		System.out.println(Math.max(dp[N-1][1], dp[N-1][2]));
	}

}
