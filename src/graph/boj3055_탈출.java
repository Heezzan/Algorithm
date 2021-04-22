package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055_탈출 {

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] map= new char[R][C];
        Pos start = null;
        int wsize = 0, gsize = 1;

        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String in = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = in.charAt(j);
                if (map[i][j] == 'S') start = new Pos(i, j);
                else if (map[i][j] == '*') {
                    q.add(new Pos(i, j));
                    wsize++;
                }
            }
        }
        q.add(start);
        int day = 1;
        boolean finish = false;

        while(!q.isEmpty()) {
            int tmp = 0;

            for (int i = 0; i < wsize; i++) {
                Pos now = q.poll();

                for (int d = 0; d < dir.length; d++) {
                    int ni = now.i + dir[d][0];
                    int nj = now.j + dir[d][1];

                    if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == '.') {
                        q.add(new Pos(ni, nj));
                        tmp++;
                        map[ni][nj] = '*';
                    }
                }
            }

            wsize = tmp;
            tmp = 0;

            for (int i = 0; i < gsize; i++) {
                Pos now = q.poll();
                map[now.i][now.j] = '*';

                for (int d = 0; d < dir.length; d++) {
                    int ni = now.i + dir[d][0];
                    int nj = now.j + dir[d][1];

                    if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                        if (map[ni][nj] == '.') {
                            q.add(new Pos(ni, nj));
                            tmp++;
                            map[ni][nj] = 'S';
                        } else if (map[ni][nj] == 'D') {
                            finish = true;
                            break;
                        }
                    }
                }
            }

            if (finish) break;

            gsize = tmp;
            day++;
        }

        System.out.println(finish ? day : "KAKTUS");
        
    }
}
