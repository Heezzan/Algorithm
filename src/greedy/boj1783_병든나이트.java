package greedy;

import java.util.Scanner;

public class boj1783_병든나이트 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ni = N-1, nj = 0;
		
		int result = 1;
		
		if (N >= 3 && M >= 7) {	// 4번 이상 가능한 경우
			result += (4 + M-7);
		} else {
			int cnt = 1;
			
			while (cnt < 4) {
				if (ni-2 >= 0 && nj+1 < M) {
					ni -= 2; nj += 1;
					result++;
				} else if (ni+2 < N && nj+1 < M) {
					ni += 2; nj += 1;
					result++;
				} else if (ni-1 >= 0 && nj+2 < M) {
					ni -= 1; nj += 2;
					result++;
				} else if (ni+1 < N && nj+2 < M) {
					ni += 1; nj += 2;
					result++;
				}
				cnt++;
			}
		}
	
		System.out.println(result);
	}

}
