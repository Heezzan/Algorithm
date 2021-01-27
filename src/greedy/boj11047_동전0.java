package greedy;

import java.util.Scanner;

public class boj11047_동전0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int result = 0;
		// 조건에서 동전의 가치인 Ai는 Ai-1의 배수라고 해서 그리디가 가능!
		for (int i = N - 1; i >= 0; i--) {
			result += K / coin[i];
			K %= coin[i];
		}

		System.out.println(result);
	}

}
