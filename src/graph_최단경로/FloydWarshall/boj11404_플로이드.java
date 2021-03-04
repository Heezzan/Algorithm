package graph_최단경로.FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11404_플로이드 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int M = stoi(br.readLine());

        int[][] graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(graph[i], Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], cost);
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1 ; j <= N; j++) {
                    if (i == j) continue;
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE
                        && graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(graph[i][j] == Integer.MAX_VALUE ? 0 : graph[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
