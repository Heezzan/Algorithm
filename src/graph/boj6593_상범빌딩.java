package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj6593_상범빌딩 {

    static int[][] dir = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

    public static class Pos {
        int h, i, j, time;

        Pos(int h, int i, int j, int time) {
            this.h = h;
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] map = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            Queue<Pos> q = new LinkedList<>();
            for (int h = 0; h < L; h++) {
                for (int i = 0; i < R; i++) {
                    map[h][i] = br.readLine().toCharArray();
                    for (int j = 0; j < C; j++) {
                        if (map[h][i][j] == 'S') {
                            visited[h][i][j] = true;
                            q.add(new Pos(h, i, j, 0));
                        }
                    }
                }
                br.readLine();
            }

            int result = 0;
            while(!q.isEmpty()) {
                Pos now = q.poll();

                if (map[now.h][now.i][now.j] == 'E') {
                    result = now.time;
                    break;
                }

                for (int d = 0; d < dir.length; d++) {
                    int nh = now.h + dir[d][0];
                    int ni = now.i + dir[d][1];
                    int nj = now.j + dir[d][2];

                    if (nh >= 0 && nh < L && ni >= 0 && ni < R && nj >= 0 && nj < C) {
                        if (map[nh][ni][nj] != '#' && !visited[nh][ni][nj]) {
                            visited[nh][ni][nj] = true;
                            q.add(new Pos(nh, ni, nj, now.time+1));
                        }
                    }
                }
            }

            if (result == 0) sb.append("Trapped!\n");
            else {
                sb.append("Escaped in ");
                sb.append(result);
                sb.append(" minute(s).\n");
            }
        }

        System.out.println(sb.toString());
    }
}
