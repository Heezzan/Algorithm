package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1761_정점들의거리 {
	static int[] depth, parents, dist;
	static List<Node>[] adj;

	public static class Node {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}
		
		depth = new int[N+1];
		parents = new int[N+1];
		dist = new int[N+1];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		depth[1] = 1;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for (Node n : adj[now.to]) {
				if (depth[n.to] == 0) {
					depth[n.to] = depth[now.to]+1;
					parents[n.to] = now.to;
					dist[n.to] = dist[now.to]+n.cost;
					q.add(n);
				}
			}
		}
		
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) 
			System.out.println(getBtnDistance(sc.nextInt(), sc.nextInt()));
		
	}
	
	public static int getBtnDistance(int a, int b) {
		int d = 0;
		
		if (depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (depth[a] != depth[b]) {
			d += (dist[a]-dist[parents[a]]);
			a = parents[a];
		}
		
		while (a != b) {
			d += (dist[a]-dist[parents[a]]);
			a = parents[a];

			d += (dist[b]-dist[parents[b]]);
			b = parents[b];
		}
		
		return d;
	}

}
