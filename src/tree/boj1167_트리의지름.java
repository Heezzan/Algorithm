package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj1167_트리의지름 {
	static List<Node>[] adj;
	static int[] toN;
	
	public static class Node {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		
		adj = new ArrayList[V+1];
		for (int v = 0; v <= V; v++)
			adj[v] = new ArrayList<>();
		
		for (int v = 0; v < V; v++) {
			int from = sc.nextInt();
			while(true) {
				int to = sc.nextInt();
				if (to == -1)	break;
				int cost = sc.nextInt();
				
				adj[from].add(new Node(to, cost));
			}
		}
		
		toN = new int[V+1];
		boolean[] visited = new boolean[V+1];
		visited[1] = true;
		dfs(1, 0, visited);
		
		int midx = 0;
		for (int i = 1; i <= V; i++) {
			if (toN[i] > toN[midx])
				midx = i;
		}
		
		Arrays.fill(visited, false);
		Arrays.fill(toN, 0);
		visited[midx] = true;
		dfs(midx, 0, visited);
		
		int result = 0;
		for (int i = 1; i <= V; i++) 
			result = Math.max(result, toN[i]);
		
		System.out.println(result);
		
	}
	
	public static void dfs(int from, int sum, boolean[] visited) {
		
		toN[from] = sum;
		
		for (Node n : adj[from]) {
			if (!visited[n.to]) {
				visited[n.to] = true;
				dfs(n.to, sum+n.cost, visited);
				visited[n.to] = false;
			}
		}
	}

}
