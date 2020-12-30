package dp;

import java.util.Scanner;

public class boj11052_카드구매하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] cards = new int[N+1];
		for (int i = 1; i <= N; i++)
			cards[i] = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (i%j == 0) 
					cards[i] = Math.max(cards[j]*(i/j), cards[i]);
				cards[i] = Math.max(cards[j]+cards[i-j], cards[i]);
			}
		}
		
		System.out.println(cards[N]);
		
	}

}
