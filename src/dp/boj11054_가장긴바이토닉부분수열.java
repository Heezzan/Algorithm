package dp;

import java.util.Scanner;

public class boj11054_가장긴바이토닉부분수열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		int[][] dp = new int[N][2];
		for (int i = 0; i < N; i++) {
			dp[i][0] = 1;
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {	
					dp[i][0] = Math.max(dp[i][0], dp[j][0]+1);
				} 
			}
		}

		int result = 0;
		for (int i = N-1; i >= 0; i--) {
			dp[i][1] = 1;
			for (int j = N-1; j > i; j--) {
				if (arr[i] > arr[j])
					dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
			}
			result = Math.max(result, dp[i][0]+dp[i][1]-1);
		}

		System.out.println(result);
	}

}
