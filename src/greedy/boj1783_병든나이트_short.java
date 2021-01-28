package greedy;

import java.util.Scanner;

public class boj1783_병든나이트_short {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if (N == 1) {
			System.out.println(1);
		} else if (N == 2) {
			System.out.println(Math.min(4, (M+1)/2));
		} else if (N >= 3) {
			if (M >= 7) {
				System.out.println(M-2);
			} else {
				System.out.println(Math.min(4, M));
			}
		}
	}

}
