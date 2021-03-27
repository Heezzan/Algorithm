package implementation;

import java.io.IOException;
import java.util.Scanner;

public class boj1756_피자굽기 {

    public static int stoi(String s) {return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int N = sc.nextInt();

        int[] oven = new int[D+1];

        int max = 1_000_000_000;
        for (int i = 1; i <= D; i++) {
            oven[i] = sc.nextInt();
            if (oven[i] > max) oven[i] = max;
            else max = oven[i];
        }

        int result = D+1;

        for (int i = 0; i < N; i++) {
            int pizza = sc.nextInt();

            if (result == 0) continue;
            for (int d = result-1; d >= 0; d--) {
                if (pizza <= oven[d]) {
                    result = d;
                    break;
                }
                if (d == 0) result = 0;
            }
        }

        System.out.println(result);

    }
}
