package class2;

import java.util.Scanner;

public class boj2798_블랙잭 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int cards[] = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = sc.nextInt();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > result)
                        result = sum;
                }
            }
        }

        System.out.println(result);

    }
}
