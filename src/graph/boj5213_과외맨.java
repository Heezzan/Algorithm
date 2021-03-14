package graph;

import java.util.*;

public class boj5213_과외맨 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static class Pos {
        int i, j, cnt;
        StringBuilder path;

        Pos(int i, int j, int cnt, StringBuilder path) {
            this.cnt = cnt;
            this.i = i;
            this.j = j;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][][] tile = new int[N][N*2][2];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            int j = (i%2 == 0) ? 0 : 1;
            for (; j+1 < N*2; j+=2) {
                tile[i][j][0] = tile[i][j+1][0] = idx++;
                tile[i][j][1] = sc.nextInt();
                tile[i][j+1][1] = sc.nextInt();
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.cnt-o2.cnt;
            }
        });
        int[][] visited = new int[N][N*2];
        visited[0][0] = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        pq.add(new Pos(0, 0, 1, sb));

        Pos result = new Pos(0, 0, 1, sb);
        while(!pq.isEmpty()) {
            Pos now = pq.poll();

            if (tile[now.i][now.j][0] > tile[result.i][result.j][0] ||
                    tile[now.i][now.j][0] == tile[result.i][result.j][0] && now.cnt < result.cnt) {
                result = now;
                if (tile[now.i][now.j][0] == idx-1) break;
            }

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni >= 0 && ni < N && nj >= 0 && nj < 2*N && tile[ni][nj][0] > 0) {
                    if (tile[now.i][now.j][0] == tile[ni][nj][0] && (visited[ni][nj] == 0 || visited[ni][nj] > now.cnt)) {
                        visited[ni][nj] = now.cnt;
                        pq.add(new Pos(ni, nj, now.cnt, now.path));
                    } else if (tile[now.i][now.j][1] == tile[ni][nj][1] && (visited[ni][nj] == 0 || visited[ni][nj] > now.cnt+1)) {
                        visited[ni][nj] = now.cnt+1;
                        StringBuilder npath = new StringBuilder(now.path);
                        npath.append(" "+tile[ni][nj][0]);
                        pq.add(new Pos(ni, nj, now.cnt+1, npath));
                    }
                }
            }
        }

        System.out.println(result.cnt);
        System.out.println(result.path.toString());

    }
}
