package graph_최단경로.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1507_궁금한민호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] fw = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                fw[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] used = new boolean[N+1][N+1];
        for (int i = 0; i <= N; i++) Arrays.fill(used[i], true);

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || k == i || k == j) continue;
                    if (fw[i][j] > fw[i][k]+fw[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (fw[i][j] == fw[i][k] + fw[k][j]) {
                        used[i][j] = false;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                if (used[i][j]) result += fw[i][j];
            }
        }

        System.out.println(result);

    }
}
