package graph_최단경로.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1956_운동 {

    public static int stoi(String s) {return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = stoi(st.nextToken());
        int E = stoi(st.nextToken());

        int[][] fw = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) Arrays.fill(fw[i], Integer.MAX_VALUE);
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            fw[stoi(st.nextToken())][stoi(st.nextToken())] = stoi(st.nextToken());
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (fw[i][k] != Integer.MAX_VALUE && fw[k][j] != Integer.MAX_VALUE
                            && fw[i][j] > fw[i][k] + fw[k][j])
                        fw[i][j] = fw[i][k] + fw[k][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n = 1; n <= V; n++) {
            if (fw[n][n] == Integer.MAX_VALUE) continue;
            min = Math.min(min, fw[n][n]);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
