package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1260_dfs와bfs {
	
	static List<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}

		for (int i = 1; i <= N; i++) 
			Collections.sort(adj[i]);
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
	
	public static void dfs(int V) {
		if (visited[V])
			return;
		
		visited[V] = true;
		System.out.print(V+" ");
		
		for (int x : adj[V]) {
			if (!visited[x])
				dfs(x);
		}
	}
	
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			
			for (int x : adj[now]) {
				if (!visited[x]) {
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}
}
