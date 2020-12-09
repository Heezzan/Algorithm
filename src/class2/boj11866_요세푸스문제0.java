package class2;

import java.util.Arrays;
import java.util.Scanner;

public class boj11866_요세푸스문제0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int idx = 1;
        boolean[] people = new boolean[N+1];
        Arrays.fill(people, true);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int k = K;
            while (k > 0) {
                if (people[idx]) {
                    if (k == 1) {
                        people[idx] = false;
                        result[i] = idx;
                    }
                    k--;
                }
                idx++;
                if (idx > N)
                    idx -= N;
            }
        }

        System.out.print("<");
        for (int i = 0; i < N; i++)
            System.out.print(i != N-1 ? result[i]+", " : result[i]);
        System.out.println(">");
    }
}
