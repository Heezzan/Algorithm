package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1080_행렬_ {

    static int[][] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrA = new int[N][M];
        arrB = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arrA[i][j] = input.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arrB[i][j] = input.charAt(j)-'0';
            }
        }

        int result = 0;
        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <= M-3; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    result++;
                    reverse(i, j);
                }
            }
        }

        boolean isSame = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        System.out.println(isSame ? result : -1);
    }

    public static void reverse(int x, int y) {

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                if (arrA[i][j] == 0) arrA[i][j] = 1;
                else arrA[i][j] = 0;
            }
        }
    }
}