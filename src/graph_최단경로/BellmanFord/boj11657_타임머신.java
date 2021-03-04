package graph_최단경로.BellmanFord;

import java.util.*;

public class boj11657_타임머신 {
    // underflow를 고려하자!
    // V=500 E=6000 minCost=-10_000 일 때
    // -500*6000*1000 = -3*10^10, Integer.MIN_VALUE=-2*10^9
    static List<Node>[] adj;

    public static class Node {
        int to, time;

        Node(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = dist[1] = 0;

        for (int n = 0; n < N-1; n++) {
            for (int i = 1; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) continue;
                for (Node nd : adj[i]) {
                    dist[nd.to] = Math.min(dist[nd.to], dist[i]+nd.time);
                }
            }
        }

        long[] check = dist.clone();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            for (Node nd : adj[i]) {
                check[nd.to] = Math.min(check[nd.to], check[i]+nd.time);
            }
        }

        boolean mcycle = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] != check[i]) {
                mcycle = true;
                break;
            }
        }

        if (mcycle) System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++)
                if (dist[i] == Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(dist[i]);
        }
    }
}
