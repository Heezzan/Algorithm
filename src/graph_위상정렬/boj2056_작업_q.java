package graph_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2056_작업_q {
    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        int[][] info = new int[N+1][3]; // [0]:time [1]:ind [2]:result
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = stoi(st.nextToken());

            int cnt = stoi(st.nextToken());
            info[i][1] = cnt;
            if (cnt == 0) {
                info[i][2] = info[i][0];
                q.add(i);
            }
            for (int j = 0; j < cnt; j++) {
                adj[stoi(st.nextToken())].add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if (info[next][2] < info[now][2]+info[next][0])
                    info[next][2] = info[now][2]+info[next][0];
                if (--info[next][1] == 0) {
                    q.add(next);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++)
            result = Math.max(result, info[i][2]);

        System.out.println(result);
    }
}
