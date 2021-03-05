package graph_최단경로.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj11780_플로이드2 {

    public static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int M = stoi(br.readLine());
        int[][] grp = new int[N+1][N+1];

        for (int i = 0; i <= N; i++)
            Arrays.fill(grp[i], Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            grp[a][b] = Math.min(grp[a][b], c);
        }

        List<Integer>[] path = new ArrayList[N*N];
        for (int i = 0; i < N*N; i++) {
            path[i] = new ArrayList();
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (grp[i][k] != Integer.MAX_VALUE && grp[k][j] != Integer.MAX_VALUE
                        && grp[i][j] > grp[i][k] + grp[k][j]) {
                        grp[i][j] = grp[i][k] + grp[k][j];
                        path[N*(i-1)+(j-1)].clear();
                        if (path[N*(i-1)+(k-1)].size() > 0 || path[N*(k-1)+(j-1)].size() > 0) {
                            for (int n : path[N*(i-1)+(k-1)])
                                path[N*(i-1)+(j-1)].add(n);
                            path[N*(i-1)+(j-1)].add(k);
                            for (int n : path[N*(k-1)+(j-1)])
                                path[N*(i-1)+(j-1)].add(n);
                        }
                        else path[N*(i-1)+(j-1)].add(k);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(grp[i][j] == Integer.MAX_VALUE ? 0 : grp[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) sb.append(0+"\n");
                else {
                    int num = N*(i-1)+(j-1);
                    sb.append(path[num].size()+2+" ");
                    sb.append(i+" ");
                    for (int k = 0; k < path[num].size(); k++)
                        sb.append(path[num].get(k)+" ");
                    sb.append(j+"\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
