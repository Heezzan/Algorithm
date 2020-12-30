package dp;

import java.util.Scanner;

public class boj9465_스티커 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] sticker = new int[2][N];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					sticker[i][j] = sc.nextInt();
				}
			}
			
			int[][] dp = new int[N][3];
			dp[0][0] = 0;
			dp[0][1] = sticker[0][0];
			dp[0][2] = sticker[1][0];
			
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[0][i];
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + sticker[1][i];
			}
			
			System.out.println(Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
		}
		
		
	}

}
