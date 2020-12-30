package ps;

import java.util.Scanner;

public class _boj1780_종이의개수 {
	public static int[][] paper;
	public static int[] result;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
	
		result = new int[3];
		find(0, 0, N);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
		
	}
	 
	public static void find(int x, int y, int n) {
		if  (same(x, y, n)) {
			result[paper[x][y]+1]++;
			return;
		}
		
		int m = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				find(x+(m*i), y+(m*j), m);
			}
		}
		
	}
	
	public static boolean same(int x, int y, int n) {
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (paper[x][y] != paper[i][j]) 
					return false;
			}
		}
		return true;
	}

}
