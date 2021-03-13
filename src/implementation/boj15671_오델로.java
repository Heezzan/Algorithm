package implementation;

import java.util.*;

public class boj15671_오델로 {
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public static class Pos {
        int dir, i, j;
        ArrayList<int[]> list;

        Pos(int dir, int i, int j, ArrayList<int[]> list) {
            this.dir = dir;
            this.i = i;
            this.j = j;
            this.list = list;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] board = new char[7][7];
        for (int i = 0; i <= 6; i++) Arrays.fill(board[i], '.');
        board[3][3] = board[4][4] = 'W';
        board[3][4] = board[4][3] = 'B';

        boolean black = false;
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            black = !black;
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (black) board[x][y] = 'B';
            else board[x][y] = 'W';

            char start = board[x][y];
            for (int d = 0; d < dir.length; d++) {
                int ni = x + dir[d][0];
                int nj = y + dir[d][1];

                if (ni > 0 && ni <= 6 && nj > 0 && nj <= 6
                        && ((black && board[ni][nj] == 'W') || (!black && board[ni][nj] == 'B'))) {
                    q.add(new Pos(d, ni, nj, new ArrayList<>()));
                }
            }

            while(!q.isEmpty()) {
                Pos now = q.poll();
                now.list.add(new int[]{now.i, now.j});

                int ni = now.i + dir[now.dir][0];
                int nj = now.j + dir[now.dir][1];
                if (ni <= 0 || ni > 6 || nj <= 0 || nj > 6 || board[ni][nj] == '.') continue;

                if (board[ni][nj] == start) {
                    for (int[] n : now.list) {
                        board[n[0]][n[1]] = start;
                    }
                } else {
                    q.add(new Pos(now.dir, ni, nj, now.list));
                }
            }
        }

        int wcnt = 0, bcnt = 0;
        for (int i = 1 ; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                System.out.print(board[i][j]);
                if (board[i][j] == 'W') wcnt++;
                else if (board[i][j] == 'B') bcnt++;
            }
            System.out.println();
        }
        System.out.println(wcnt > bcnt ? "White" : "Black");
    }
}
