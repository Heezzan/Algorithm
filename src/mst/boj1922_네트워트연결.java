package mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1922_네트워트연결 {
	
	static class Node {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Node>[] adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			adj[from].add(new Node(to, cost));
			adj[to].add(new Node(from, cost));
		}
		
		boolean[] check = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost-o2.cost;
			}
		});
		
		check[1] = true;
		for (Node n : adj[1])
			pq.add(n);
		
		int result = 0;
		for (int i = 0; i < N-1; i++) {
			Node n = null;
			while(!pq.isEmpty()) {
				n = pq.poll();
				
				if (!check[n.to])
					break;
			}
			
			check[n.to] = true;
			result += n.cost;
			
			for (Node next : adj[n.to])
				pq.add(next);
		}
		
		System.out.println(result);
		
	}

}
