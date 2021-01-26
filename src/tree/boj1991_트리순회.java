package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991_트리순회 {
	static int[][] tree;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new int[N][2];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			tree[root][0] = left;
			tree[root][1] = right;
		}
		
		System.out.println(preorder(0, new StringBuilder()));
		System.out.println(inorder(0, new StringBuilder()));
		System.out.println(postorder(0, new StringBuilder()));
		
	}
	
	public static StringBuilder preorder(int n, StringBuilder sb) {
		sb.append((char)('A'+n));
		if (tree[n][0] > 0) preorder(tree[n][0], sb);
		if (tree[n][1] > 0) preorder(tree[n][1], sb);
		return sb;
	}
	
	public static StringBuilder inorder(int n, StringBuilder sb) {
		if (tree[n][0] > 0) inorder(tree[n][0], sb);
		sb.append((char)('A'+n));
		if (tree[n][1] > 0) inorder(tree[n][1], sb);
		return sb;
	}
	
	public static StringBuilder postorder(int n, StringBuilder sb) {
		if (tree[n][0] > 0) postorder(tree[n][0], sb);
		if (tree[n][1] > 0) postorder(tree[n][1], sb);
		sb.append((char)('A'+n));
		return sb;
	}
	
	

}
