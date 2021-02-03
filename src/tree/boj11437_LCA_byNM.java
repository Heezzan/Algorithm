package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj11437_LCA_byNM {
	static int[] depth, parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		depth = new int[N+1];
		parents = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		depth[1] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int child : adj[now]) {
				if (depth[child] == 0) {
					parents[child] = now;
					depth[child] = depth[now]+1;
					q.add(child);
				}
			}
		}
		
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			System.out.println(lca(sc.nextInt(), sc.nextInt()));
		}
	}
	
	public static int lca(int a, int b) {
		while (depth[a] != depth[b]) {
			if (depth[a] > depth[b])	a = parents[a];
			else b = parents[b];
		}
		
		while (a != b) {
			a = parents[a];
			b = parents[b];
		}
		
		return a;
	}
}
