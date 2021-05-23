package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1562_계단수 {

    /*
    * 모든 인접한 자리수의 차이가 1이 나는 수 = 계단 수
    * 길이가 N인 계단수는 총 몇 개 있는지 구해라
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int mod = 1_000_000_000;

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N+1][10][1<<10];
        for (int i = 1; i < 10; i++) dp[1][i][1<<i] = 1;

        for (int i = 2; i <= N; i++) {

            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < (1<<10); k++) {
                    // j-1 비트가 1인 경우
                    if (j-1 >= 0 && dp[i-1][j-1][k] > 0) {
                        dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j-1][k]) % mod;
                    }

                    if (j+1 < 10 && dp[i-1][j+1][k] > 0) {
                        dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j+1][k]) % mod;
                    }
                }
            }
        }


        int result = 0;
        for (int i = 0; i < 10; i++) result = (result + dp[N][i][(1<<10)-1]) % mod;
        System.out.println(result);

//        long test = 0;
//        for (int i = 1; i <= 40; i++) {
//            long tmp = 0;
//            for (int j = 0; j < 10; j++) {
//                tmp = (tmp + dp[i][j][(1<<10)-1]) % mod;
//            }
//            test += tmp;
//        }
//        System.out.println(test);

    }
}