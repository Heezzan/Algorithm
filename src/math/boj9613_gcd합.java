package math;

import java.util.Scanner;

public class boj9613_gcd합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long gcdSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    // 둘의 최대공약수를 더하고
                    gcdSum += gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
                }
            }

            System.out.println(gcdSum);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}