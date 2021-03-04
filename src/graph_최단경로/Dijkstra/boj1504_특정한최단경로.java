package graph_최단경로.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1504_특정한최단경로 {
    static List<Node>[] adj;
    static int N;

    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = stoi(st.nextToken());
        int v2 = stoi(st.nextToken());

        int[] fs = dijkstra(1);
        int[] fv1 = dijkstra(v1);
        int[] fv2 = dijkstra(v2);
        // 1~v1 v1-v2 v2-n
        // 1~v2 v2-v1 v1-n
        int result = -1;
        if (fs[v1] != Integer.MAX_VALUE && fv1[v2] != Integer.MAX_VALUE && fv2[N] != Integer.MAX_VALUE) {
            result = fs[v1]+fv1[v2]+fv2[N];
        }
        if (fs[v2] != Integer.MAX_VALUE && fv2[v1] != Integer.MAX_VALUE && fv1[N] != Integer.MAX_VALUE) {
            if (result == -1) result = fs[v2]+fv2[v1]+fv1[N];
            else result = Math.min(result, fs[v2]+fv2[v1]+fv1[N]);
        }

        System.out.println(result);
    }

    public static int[] dijkstra(int s) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));
        dist[s] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (dist[now.to] < now.cost) continue;
            for (Node n : adj[now.to]) {
                if (dist[n.to] > dist[now.to]+n.cost) {
                    dist[n.to] = dist[now.to]+n.cost;
                    q.add(new Node(n.to, dist[n.to]));
                }
            }
        }

        return dist;
    }

}
