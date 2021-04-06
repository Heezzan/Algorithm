package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1103_게임 {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, M;
    static int[][] board, dp;

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = in.charAt(j) == 'H' ? -1 : in.charAt(j)-'0';
            }
        }

        dfs(new Pos(0, 0), new boolean[N][M]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[0][0] == Integer.MAX_VALUE ? -1 : dp[0][0]);
    }

    public static int dfs(Pos p, boolean[][] visited) {

        if (dp[p.i][p.j] != 0) return dp[p.i][p.j];

        visited[p.i][p.j] = true;

        for (int d = 0; d < dir.length; d++) {
            int ni = p.i + board[p.i][p.j]*dir[d][0];
            int nj = p.j + board[p.i][p.j]*dir[d][1];

            if (ni < 0 || ni >= N || nj < 0 || nj >= M || board[ni][nj] == -1) {
                dp[p.i][p.j] = Math.max(dp[p.i][p.j], 1);
                continue;
            }

            if (visited[ni][nj]) return dp[p.i][p.j] = -1;

            int tmp = dfs(new Pos(ni, nj), visited);
            if (tmp == -1) return dp[p.i][p.j] = -1;
            else dp[p.i][p.j] = Math.max(dp[p.i][p.j], tmp+1);
        }

        visited[p.i][p.j] = false;
        return dp[p.i][p.j];
    }

}
