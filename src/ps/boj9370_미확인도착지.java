package ps;

import java.io.*;
import java.util.*;

public class boj9370_미확인도착지 {
    public static List<Node>[] adj;

    public static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int btw = 0;

            adj = new ArrayList[N+1];
            for (int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
                if ((a == G && b == H) || (a == H && b == G)) btw = d;
            }

            int[] cand = new int[T];
            for (int i = 0; i < T; i++) {
                cand[i] = Integer.parseInt(br.readLine());
            }

            int[] fs = dijkstra(S, N);
            int[] fg = dijkstra(G, N);
            int[] fh = dijkstra(H, N);

            Arrays.sort(cand);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cand.length; i++) {
                if (fs[cand[i]] == fs[G] + fh[cand[i]] + btw || fs[cand[i]] == fs[H] + fg[cand[i]] + btw)
                    sb.append(cand[i]+" ");
            }

            System.out.println(sb.toString());
        }
    }

    public static int[] dijkstra(int start, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });

        boolean[] visited = new boolean[N+1];
        int[] minCost = new int[N+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to])    continue;
            visited[now.to] = true;
            minCost[now.to] = now.cost;

            for (Node n : adj[now.to]) {
                pq.add(new Node(n.to, now.cost+n.cost));
            }
        }

        return minCost;
    }

}
