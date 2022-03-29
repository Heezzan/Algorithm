package bruteforce_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1018_체스판다시칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        char[][] origin = new char[][]{{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
                                    , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
                                    , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
                                    , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
                                    , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
                                    , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
                                    , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
                                    , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
                                    , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int bcnt = 0, wcnt = 0;

                for (int m = 0; m < 8; m++) {
                    for (int n = 0; n < 8; n++) {
                        if (board[i+m][j+n] != origin[m][n]) wcnt++;
                        if (board[i+m][j+n] != origin[m+1][n]) bcnt++;
                    }
                }
                result = Math.min(result, Math.min(bcnt, wcnt));
            }
        }

        System.out.println(result);

    }
}