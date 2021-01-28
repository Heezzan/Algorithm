package greedy;

import java.util.Scanner;

public class boj2875_대회or인턴 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int team = Math.min(N/2, M);
		int left = (N-team*2) + (M-team);
		
		while(left < K) {
			left += 3;
			team--;
		}
		
		System.out.println(team);
		
	}

}
