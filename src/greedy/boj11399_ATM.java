package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class boj11399_ATM {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] p = new int[N];
		for (int i = 0; i < N; i++)
			p[i] = sc.nextInt();
		
		Arrays.sort(p);
		
		int[][] result = new int[N][2];
		result[0][0] = result[0][1] = p[0];
		for (int i = 1; i < N; i++) {
			result[i][0] = result[i-1][0]+p[i];
			result[i][1] = result[i-1][1]+result[i][0];
		}
		
		System.out.println(result[N-1][1]);
	}

}
