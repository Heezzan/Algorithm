package math;

import java.util.Scanner;

public class boj1748_수이어쓰기1 {

    public static void main(String[] args) {
        solve1();
        solve2();
    }

    public static void solve1() {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (num > 0) {
                num /= 10;
                result++;
            }

        }

        System.out.println(result);
    }


    public static void solve2() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= N; i*=10) {
            result += (N-i) + 1;
        }

        System.out.println(result);
    }
}
