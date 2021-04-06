package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17953_디저트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());   // DAY
        int K = Integer.parseInt(st.nextToken());   // KIND

        int[][] food = new int[K][D];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < D; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp= new int[K][D];
        for (int i = 0; i < K; i++) dp[i][0] = food[i][0];

        for (int day = 1; day < D; day++) {
            int[] tmp = new int[K];
            for (int i = 0; i < K; i++) tmp[i] = dp[i][day-1];
            Arrays.sort(tmp);

            for (int f = 0; f < K; f++) {
                if (dp[f][day-1] == tmp[K-1]) {
                    if (K == 1) dp[f][day] = dp[f][day-1]+food[f][day]/2;
                    else dp[f][day] = Math.max(dp[f][day-1]+(food[f][day]/2), tmp[K-2]+food[f][day]);
                }
                else dp[f][day] = tmp[K-1]+food[f][day];
            }
        }

        int result = 0;
        for (int i = 0; i < K; i++) result = Math.max(result, dp[i][D-1]);

        System.out.println(result);
    }
}
