package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj2151_거울설치 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] mirror = {{true, true, false, true}, {true, true, true, false}
                                ,{false, true, true, true}, {true, false, true, true}};

    static class Pos {
        int i, j, dir, cnt;

        Pos (int i, int j) {
            this.i = i;
            this.j = j;
        }

        Pos (int i, int j, int dir, int cnt) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] house = new char[N][N];
        for (int i = 0; i < N; i++)
            house[i] = br.readLine().toCharArray();

        Pos start = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] == '#') {
                    start = new Pos(i, j);
                    i = N;
                    break;
                }
            }
        }

        int[][][] visited = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        for (int d = 0; d < 4; d++)
            visited[start.i][start.j][d] = 0;
        Queue<Pos> q = new LinkedList<>();

        for (int d = 0; d < dir.length; d++) {
            int ni = start.i + dir[d][0];
            int nj = start.j + dir[d][1];

            if (ni < 0 || ni >= N || nj < 0 || nj >= N || house[ni][nj] == '*') continue;
            visited[ni][nj][d] = 0;
            q.add(new Pos(ni, nj, d, 0));
        }

        int result = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pos now = q.poll();

            if (house[now.i][now.j] == '#') {
                result = Math.min(result, now.cnt);
                continue;
            }

            if (house[now.i][now.j] == '.') {
                int ni = now.i + dir[now.dir][0];
                int nj = now.j + dir[now.dir][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || house[ni][nj] == '*') continue;
                if (visited[ni][nj][now.dir] >= now.cnt) {
                    visited[ni][nj][now.dir] = now.cnt;
                    q.add(new Pos(ni, nj, now.dir, now.cnt));
                }
            } else if (house[now.i][now.j] == '!') {
                for (int d = 0; d < dir.length; d++) {
                    if (mirror[now.dir][d]) {
                        int ni = now.i + dir[d][0];
                        int nj = now.j + dir[d][1];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= N || house[ni][nj] == '*') continue;
                        if (now.dir == d && visited[ni][nj][d] >= now.cnt) {
                            visited[ni][nj][d] = now.cnt;
                            q.add(new Pos(ni, nj, d, now.cnt));
                        } else if (now.dir != d && visited[ni][nj][d] >= now.cnt+1) {
                            visited[ni][nj][d] = now.cnt+1;
                            q.add(new Pos(ni, nj, d, now.cnt+1));
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
