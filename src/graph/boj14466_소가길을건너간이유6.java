package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj14466_소가길을건너간이유6 {
	static int N, result;
	static boolean[][][] map;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static class Pos {
		int i, j;
		
		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int K = sc.nextInt();
		int R = sc.nextInt();
		
		map = new boolean[N+1][N+1][5];
		for (int r = 0; r < R; r++) {
			int ai = sc.nextInt();	int aj = sc.nextInt();
			int bi = sc.nextInt();	int bj = sc.nextInt();
			int di = ai-bi;	int dj = aj-bj;
			
			if (di == 0 && dj == 1) {	// a오b왼
				map[ai][aj][2] = map[bi][bj][0] = true;
			} else if (di == 0 && dj == -1) {
				map[ai][aj][0] = map[bi][bj][2] = true;
			} else if (di == 1 && dj == 0) {	//a아b위
				map[ai][aj][3] = map[bi][bj][1] = true;
			} else if (di == -1 && dj == 0) {
				map[ai][aj][1] = map[bi][bj][3] = true;
			}
		}
		
		List<Pos> cows = new ArrayList<>();
		for (int k = 0; k < K; k++) {
			int x = sc.nextInt(); int y = sc.nextInt();
			map[x][y][4] = true;
			cows.add(new Pos(x, y));
		}
		
		result = cows.size()*cows.size();
		for (Pos p : cows) {
			bfs(p);
		}
		
		System.out.println(result/2);
	}
	
	public static void bfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][N+1];
		
		visited[p.i][p.j] = true;
		q.add(p);
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			if (map[now.i][now.j][4])
				result--;
			
			for (int d = 0; d < dir.length; d++) {
				if (map[now.i][now.j][d])
					continue;
				
				int ni = now.i + dir[d][0];
				int nj = now.j + dir[d][1];
				
				if (ni > 0 && ni <= N && nj > 0 && nj <= N && !visited[ni][nj]) {
					visited[ni][nj] = true;
					q.add(new Pos(ni, nj));
				}
			}
		}
	}
}
