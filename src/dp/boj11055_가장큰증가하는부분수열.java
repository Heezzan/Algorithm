package dp;

import java.util.Scanner;

public class boj11055_가장큰증가하는부분수열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		int[] dp = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = arr[i];
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
			
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}

}
