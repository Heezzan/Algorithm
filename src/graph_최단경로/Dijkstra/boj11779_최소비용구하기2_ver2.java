package graph_최단경로.Dijkstra;

import java.util.*;

public class boj11779_최소비용구하기2_ver2 {

    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Node>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }
        int S = sc.nextInt();
        int D = sc.nextInt();

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        dist[S] = 0;
        int[] parents = new int[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.to] < now.cost) continue;

            for (Node n : adj[now.to]) {
                if (dist[n.to] > dist[now.to]+n.cost) {
                    dist[n.to] = dist[now.to]+n.cost;
                    parents[n.to] = now.to;
                    pq.add(new Node(n.to, dist[n.to]));
                }
            }
        }

        System.out.println(dist[D]);
        List<Integer> list = new ArrayList<>();
        list.add(D);
        while(parents[D] != S) {
            list.add(parents[D]);
            D = parents[D];
        }
        list.add(S);
        System.out.println(list.size());
        for (int i = list.size()-1; i >= 0; i--)
            System.out.print(list.get(i)+" ");

    }
}
