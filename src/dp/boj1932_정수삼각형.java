package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1932_정수삼각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][0] + triangle[i][j];
                else if (j == i) dp[i][j] = dp[i-1][i-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.println(result);
    }
}
