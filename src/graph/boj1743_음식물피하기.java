package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1743_음식물피하기 {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] map, visited;

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        map = new boolean[N+1][M+1];
        for (int k = 0; k < K; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            map[n][m] = true;
        }

        visited = new boolean[N+1][M+1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && map[i][j]) {
                    result = Math.max(result, count(new Pos(i, j)));
                }
            }
        }

        System.out.println(result);
    }

    public static int count(Pos p) {
        Queue<Pos> q = new LinkedList<>();
        int cnt = 0;
        visited[p.i][p.j] = true;
        q.add(p);

        while(!q.isEmpty()) {
            Pos now = q.poll();
            cnt++;

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni > 0 && ni < map.length && nj > 0 && nj < map[0].length && !visited[ni][nj] && map[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new Pos(ni, nj));
                }
            }
        }

        return cnt;
    }
}
