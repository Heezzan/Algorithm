package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2096_내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] board = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][][] result = new int[N][3][2];
        result[0][0][0] = result[0][0][1] = board[0][0];
        result[0][1][0] = result[0][1][1] = board[0][1];
        result[0][2][0] = result[0][2][1] = board[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    result[i][j][0] = board[i][j] + Math.min(result[i-1][j-1][0], Math.min(result[i-1][j][0], result[i-1][j+1][0]));
                    result[i][j][1] = board[i][j] + Math.max(result[i-1][j-1][1], Math.max(result[i-1][j][1], result[i-1][j+1][1]));
                } else {
                    result[i][j][0] = board[i][j] + Math.min(result[i-1][j][0], j == 0 ? result[i-1][j+1][0] : result[i-1][j-1][0]);
                    result[i][j][1] = board[i][j] + Math.max(result[i-1][j][1], j == 0 ? result[i-1][j+1][1] : result[i-1][j-1][1]);
                }
            }
         }

        System.out.print(Math.max(result[N-1][0][1], Math.max(result[N-1][1][1], result[N-1][2][1]))+" ");
        System.out.println(Math.min(result[N-1][0][0], Math.min(result[N-1][1][0], result[N-1][2][0])));

    }
}
