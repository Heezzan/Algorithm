package graph_위상정렬;

import java.util.*;

public class boj1766_문제집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        int[] ind = new int[N+1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            ind[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0)
                pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now+" ");

            for (int next : adj[now]) {
                if (--ind[next] == 0)
                    pq.add(next);
            }
        }

        System.out.println(sb.toString());
    }
}
