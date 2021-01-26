package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj1967_트리의지름 {
	static List<Node>[] adj;
	static int N, midx;
	
	public static class Node {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj = new List[N+1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < N-1; i++) {
			String[] in = br.readLine().split(" ");
			int from = Integer.parseInt(in[0]);
			int to = Integer.parseInt(in[1]);
			int cost = Integer.parseInt(in[2]);
			
			adj[from].add(new Node(to, cost));
			adj[to].add(new Node(from, cost));
		}
		
		int[] dist = bfs(new Node(1, 0));
		dist = bfs(new Node(midx, 0));
		System.out.println(dist[midx]);
	}
	
	public static int[] bfs(Node start) {
		int[] dist = new int[N+1];
		Queue<Node> q = new LinkedList<>();
		
		q.add(start);
		midx = 1;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if (dist[midx] < dist[now.to])
				midx = now.to;
			
			for (Node n : adj[now.to]) {
				if (n.to != start.to && dist[n.to] == 0) {
					dist[n.to] = dist[now.to] + n.cost;
					q.add(n);
				}
			}
		}
		
		return dist;
	}
	
	
}
