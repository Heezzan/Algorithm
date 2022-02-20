package dp;

import java.util.Scanner;

public class boj1010_다리놓기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[][] pascal = new long[31][31];
        pascal[1][0] = pascal[1][1] = 1;

        for (int i = 2; i < 31; i++) {
            for (int j = 0; j <= i; j++) {
                if ( j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }

        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(pascal[M][N]);

        }

    }
}
