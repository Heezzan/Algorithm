package dp;

import java.util.Scanner;

public class boj2098_외판원순회 {
    static int[][] map, dp;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp = new int[1<<N][N];
        move(0, 0, 1<<0);

        System.out.println(dp[1][0]);
    }

    public static int move(int start, int now, int path) {
        if (dp[path][now] != 0) return dp[path][now];

        if (path == (1<<N)-1) {
            if (map[now][start] > 0) return map[now][start];
            else return Integer.MAX_VALUE-1_000_000;
        }

        int min = Integer.MAX_VALUE-1_000_000;
        for (int next = 0; next < N; next++) {
            if (map[now][next] > 0 && (path & (1<<next)) == 0) {
                min = Math.min(min, move(start, next, path | (1<<next)) + map[now][next]);
            }
        }

        return dp[path][now] = min;
    }

}
