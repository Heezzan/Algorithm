package dp;

import java.util.Scanner;

public class boj1912_연속합 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		int[] dp = new int[N];	// 
		
		dp[0] = arr[0];
		int result = dp[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			result = Math.max(result, dp[i]);
		}
		
//		for (int i = 0; i < N; i++) {
//			dp[i] = arr[i];
//			int psum = 0;
//			for (int j = i-1; j >= 0; j--) {
//				psum += arr[j+1];
//				dp[i] = Math.max(dp[i], dp[j]+psum);
//			}
//			result = Math.max(result, dp[i]);
//		}
		
		
		System.out.println(result);
			
	}

}
