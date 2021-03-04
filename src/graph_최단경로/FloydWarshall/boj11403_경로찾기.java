package graph_최단경로.FloydWarshall;

import java.io.IOException;
import java.util.Scanner;

public class boj11403_경로찾기 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

}
