package class3;

import java.util.Scanner;

public class boj2630_색종이만들기 {

    static int[][] paper;
    static int white, blue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        white = 0;
        blue = 0;
        isSame(0, 0, N);
        System.out.println(white+"\n"+blue);
    }

    public static void isSame(int si, int sj, int N) {
        boolean same = true;

        for (int i = si; i < si+N; i++) {
            for (int j = sj; j < sj+N; j++) {
                if (paper[i][j] != paper[si][sj]) {
                    same = false;
                    i = si+N;
                    break;
                }
            }
        }

        if (same) {
            if (paper[si][sj] == 0) white++;
            else blue++;
        } else {
            isSame(si, sj, N/2);
            isSame(si+(N/2), sj, N/2);
            isSame(si, sj+(N/2), N/2);
            isSame(si+(N/2), sj+(N/2), N/2);
        }
    }
}
