package graph_위상정렬;

import java.util.*;

public class boj2252_줄세우기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        int[] ind = new int[N+1];
        for (int i = 0; i < M; i++) {
            int front = sc.nextInt();
            int back = sc.nextInt();

            ind[back]++;
            adj[front].add(back);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now+" ");

            for (int next : adj[now]) {
                ind[next]--;
                if (ind[next] == 0) q.add(next);
            }
        }
    }
}
