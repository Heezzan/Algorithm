package graph_최단경로.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1389_케빈베이컨의6단계법칙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] kb = new int[N+1][N+1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(kb[i], Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            kb[a][b] = kb[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (kb[i][k] != Integer.MAX_VALUE && kb[k][j] != Integer.MAX_VALUE
                        && kb[i][j] > kb[i][k] + kb[k][j])
                        kb[i][j] = kb[i][k] + kb[k][j];
                }
            }
        }

        int result = 0, kbn = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                sum += kb[i][j];
            }
            if (sum < kbn) {
                result = i;
                kbn = sum;
            }
        }

        System.out.println(result);
    }
}
