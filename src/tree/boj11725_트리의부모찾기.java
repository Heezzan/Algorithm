package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj11725_트리의부모찾기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < N-1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A].add(B);
			adj[B].add(A);
		}
		
		int[] parents = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (Integer child : adj[now]) {
				if (parents[child] == 0) {
					parents[child] = now;
					q.add(child);
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	}

}
