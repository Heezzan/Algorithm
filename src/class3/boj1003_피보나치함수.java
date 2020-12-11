package class3;

import java.util.Scanner;

public class boj1003_피보나치함수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[1][1] = 1;
        int last = 1;

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            if (last < N) {
                for (int i = last+1; i <= N; i++) {
                    fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
                    fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
                }
                last = N;
            }
            System.out.println(fibo[N][0] + " " + fibo[N][1]);
        }
    }
}
