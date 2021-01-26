package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj11437_LCA {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();
		
		// 인접리스트로 트리를 입력받습니다
		for (int n = 0; n < N-1; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int[] parents = new int[N+1];	// 자신의 부모 노드를 저장하는 배열
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		visited[1] = true;
		q.add(1);
		while(!q.isEmpty()) {	// bfs를 이용해서 자신의 자식들을 방문하며 자식의 parents 배열에 자신을 저장해줍니다.
			Integer now = q.poll();
			
			for (Integer child : adj[now]) {
				if (!visited[child]) {
					visited[child] = true;
					parents[child] = now;
					q.add(child);
				}
			}
		}
		
		int M = sc.nextInt();
		for (int m = 0; m < M; m++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int now = a;
			List<Integer> allparents = new ArrayList<>(); 
			while (now != 0) {
				allparents.add(now);
				now = parents[now];
			}
			
			now = b;
			while (now != 0) {
				if (allparents.contains(now)) {
					System.out.println(now);
					break;
				}
				now = parents[now];
			}
		}
	}
}
