package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026_적록색약 {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] picture;
    static boolean[][][] visited;
    static int N;

    static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];

        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N][2];
        int[] result = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j][0]) {
                    result[0]++;
                    bfs(new Pos(i, j), false);
                }
                if (!visited[i][j][1]) {
                    result[1]++;
                    bfs(new Pos(i, j), true);
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static void bfs(Pos p, boolean rg) {
        Queue<Pos> q = new LinkedList<>();
        visited[p.i][p.j][rg ? 1 : 0] = true;
        q.add(p);

        while(!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj][rg ? 1 : 0]) continue;

                if (picture[now.i][now.j] == picture[ni][nj]
                        || (rg && picture[now.i][now.j] != 'B'
                        && picture[ni][nj] != 'B')) {
                    visited[ni][nj][rg ? 1 : 0] = true;
                    q.add(new Pos(ni, nj));
                }
            }
        }
    }
}
