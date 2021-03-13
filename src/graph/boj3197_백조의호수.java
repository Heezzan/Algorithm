package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj3197_백조의호수 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static int R, C;

    static class Pos {
        int i, j, time;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        Pos(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] time = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Pos> q = new LinkedList<>();
        Pos start = null;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 내 주변 중 하나라도 .이 있는 경우 큐에 넣는다.
                if (map[i][j] == '.') continue;
                if (map[i][j] == 'L') {
                    if (start == null) {
                        map[i][j] = '.';
                        start = new Pos(i, j, 0);
                    }
                    continue;
                }

                for (int d = 0; d < dir.length; d++) {
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];

                    if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != 'X') {
                        time[i][j] = 1;
                        q.add(new Pos(i, j));
                        break;
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == 'X' && time[ni][nj] == 0) {
                    time[ni][nj] = time[now.i][now.j]+1;
                    q.add(new Pos(ni, nj));
                }
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.time-o2.time;
            }
        });

        boolean[][] visited = new boolean[R][C];
        visited[start.i][start.j] = true;
        pq.add(start);
        int result = Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            Pos now = pq.poll();

            if (map[now.i][now.j] == 'L') {
                result = Math.min(result, now.time);
            }

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.add(new Pos(ni, nj, Math.max(now.time, time[ni][nj])));
                }
            }
        }

        System.out.println(result);
    }
}
