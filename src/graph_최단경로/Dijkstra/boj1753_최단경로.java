package graph_최단경로.Dijkstra;

import java.util.*;

public class boj1753_최단경로 {
    static List<Node>[] adj;

    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        int S = sc.nextInt();
        for (int e = 0; e < E; e++) {
            adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V+1];

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });
        pq.add(new Node(S, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;
            dist[now.to] = now.cost;

            for (Node n : adj[now.to]) {
                if (dist[n.to] > dist[now.to]+n.cost) {
                    pq.add(new Node(n.to, dist[now.to]+n.cost));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}
