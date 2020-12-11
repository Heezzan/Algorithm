package class2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1966_프린터큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] q = new int[N];
			Integer[] ordered = new Integer[N];

			for (int i = 0; i < N; i++) {
				q[i] = sc.nextInt();
				ordered[i] = q[i];
			}

			Arrays.sort(ordered, Collections.reverseOrder());

			int idx = 0, oidx = 0, cnt = 1;
			while (true) {
				if (q[idx] == ordered[oidx]) {
					if (idx == M) {
						System.out.println(cnt);
						break;
					}
					oidx++;
					if (oidx >= N)
						oidx -= N;
					cnt++;
				}
				idx++;
				if (idx >= N)
					idx -= N;
			}
		}
	}
}
