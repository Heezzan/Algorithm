package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1012_유기농배추 {
	
	public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static boolean[][] land;
	public static int N, M;
	
	public static class Pos {
		int i, j;
		
		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			
			land = new boolean[M][N];
			for (int k = 0; k < K; k++) {
				land[sc.nextInt()][sc.nextInt()] = true;
			}

			int result = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (land[i][j]) {
						result++;
						dfs(new Pos(i, j));
					}
				}
			}
			
			System.out.println(result);
		}
	}
	
	public static void dfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(p);
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			for (int d = 0; d < dir.length; d++) {
				int ni = now.i + dir[d][0];
				int nj = now.j + dir[d][1];
				
				if (ni >= 0 && ni < M && nj >= 0 && nj < N && land[ni][nj]) {
					land[ni][nj] = false;
					q.add(new Pos(ni, nj));
				}
			}
		}
	}
}
