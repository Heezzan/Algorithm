package graph_최단경로.Dijkstra;

import java.util.*;

public class boj1916_최소비용구하기 {

    static class Node {
        int to, cost;

        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Node>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }
        int S = sc.nextInt();
        int D = sc.nextInt();

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];

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

        System.out.println(dist[D]);
    }
}
