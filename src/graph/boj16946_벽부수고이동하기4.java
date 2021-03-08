package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16946_벽부수고이동하기4 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    static int N, M;

    static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return i == pos.i &&
                    j == pos.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(new Pos(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j =0; j < M; j++) {
                sb.append(map[i][j] == -1 ? 0 : map[i][j] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(Pos p) {
        Queue<Pos> q = new LinkedList<>();
        map[p.i][p.j] = -1;
        q.add(p);
        int cnt = 0;

        HashSet<Pos> outline = new HashSet<>();

        while(!q.isEmpty()) {
            Pos now = q.poll();
            cnt++;

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M ) {
                    if (map[ni][nj] == 0) {
                        map[ni][nj] = -1;
                        q.add(new Pos(ni, nj));
                    } else if (map[ni][nj] > 0) {
                        outline.add(new Pos(ni, nj));
                    }
                }
            }
        }

        for (Pos pos : outline) {
            map[pos.i][pos.j] += cnt;
        }
    }
}
