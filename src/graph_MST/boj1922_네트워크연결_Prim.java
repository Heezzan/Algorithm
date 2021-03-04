package graph_MST;

import java.util.*;

public class boj1922_네트워크연결_Prim {
//    그래프에서 일부 간선을 선택해서 가중치 합이 최소가 되도록 => MST
    static List<Node>[] adj;
    static int N;

    public static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        System.out.println(prim());
    }

    public static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });
        boolean[] visited = new boolean[N+1];
        int cost = 0;

        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;
            cost += now.cost;

            for (Node n : adj[now.to]) {
                if (!visited[n.to]) pq.add(n);
            }
        }

        return cost;
    }

}
