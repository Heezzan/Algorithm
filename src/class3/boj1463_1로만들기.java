package class3;

import java.util.Scanner;

public class boj1463_1로만들기 {

	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		makeOne(N, 0);

		System.out.println(result);
	}
	
	static void makeOne(int n, int cnt) {
		
		if (n == 1 && cnt < result) {
			result = cnt;
			return;
		}

		if (cnt > result)
			return;
		
		if (n % 2 == 0)
			makeOne(n/2, cnt+1);
		
		if (n % 3 == 0) 
			makeOne(n/3, cnt+1);
		makeOne(n-1, cnt+1);
	}

}
