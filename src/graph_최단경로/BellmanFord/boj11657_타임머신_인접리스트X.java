package graph_최단경로.BellmanFord;

import java.util.Arrays;
import java.util.Scanner;

public class boj11657_타임머신_인접리스트X {

    public static class Node {
        int from, to, time;

        Node(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Node[] edges = new Node[M];
        for (int m = 0; m < M; m++) {
            edges[m] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = dist[1] = 0;

        for (int n = 0; n < N-1; n++) {
            for (int i = 0; i < edges.length; i++) {
                if (dist[edges[i].from] == Integer.MAX_VALUE) continue;
                dist[edges[i].to] = Math.min(dist[edges[i].to], dist[edges[i].from]+edges[i].time);
            }
        }

        long[] check = dist.clone();
        for (int i = 0; i < edges.length; i++) {
            if (dist[edges[i].from] == Integer.MAX_VALUE) continue;
            dist[edges[i].to] = Math.min(dist[edges[i].to], dist[edges[i].from]+edges[i].time);
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
