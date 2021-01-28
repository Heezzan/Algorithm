package greedy;

import java.util.Scanner;

public class boj1080_행렬 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] origin = new char[N][M];
		for (int i = 0; i < N; i++) 
			origin[i] = sc.next().toCharArray();
		
		char[][] want = new char[N][M];
		for (int i = 0; i < N; i++)
			want[i] = sc.next().toCharArray();
		
		
		int result = 0;
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if (origin[i][j] != want[i][j]) {
					result++;
					for (int ii = 0; ii < 3; ii++) {
						for (int jj = 0; jj < 3; jj++) {
							if (origin[i+ii][j+jj] == '0')	origin[i+ii][j+jj] = '1';
							else origin[i+ii][j+jj] = '0';
						}
					}
				}
			}
		}
		
		boolean same = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (origin[i][j] != want[i][j]) {
					same = false;
					j = M;
					i = N;
				}
			}
		}
		
		System.out.println(same ? result : -1);
	}

}
