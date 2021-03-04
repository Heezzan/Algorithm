package graph_MST;

import java.util.*;

public class boj1197_최소스패닝트리_Kruskal {
    static int[] parents;

    static class Node {
        int from, to, cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });

        parents = new int[V+1];
        for (int i = 1; i <= V; i++) parents[i] = i;

        for (int e = 0; e < E; e++) {
            pq.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        int result = 0, cnt = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (union(now.from, now.to)) {
                result += now.cost;
                cnt++;
            }

            if (cnt == V-1) break;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        parents[x] = y;
        return true;
    }
}
