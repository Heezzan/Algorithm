package graph_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2056_작업_pq {
    public static class Node {
        int idx, time;

        Node (int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        int[][] info = new int[N+1][2]; // [0]:time [1]:ind

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time-o2.time;
            }
        });
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = stoi(st.nextToken());

            int n = stoi(st.nextToken());
            info[i][1] = n;
            if (n == 0) pq.add(new Node(i, info[i][0]));
            for (int j = 0; j < n; j++) {
                adj[stoi(st.nextToken())].add(i);
            }
        }

        int result = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            result = Math.max(result, now.time);

            for (int next : adj[now.idx]) {
                // pq가 아닐 경우 꺼내는 애가 항상 제일 늦은 시간이라는걸 보장 못함!
                if (--info[next][1] == 0) {
                    pq.add(new Node(next, now.time+info[next][0]));
                }
            }
        }

        System.out.println(result);
    }
}
